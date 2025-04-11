package com.sam.userService.service;


import com.sam.userService.config.exception.UserEmailAlreadyExist;
import com.sam.userService.config.exception.UserNameAlreadyExist;
import com.sam.userService.config.exception.UserNotFoundException;
import com.sam.userService.config.exception.UserRoleNotFoundException;
import com.sam.userService.dto.request.LoginRequestDTO;
import com.sam.userService.dto.request.UserRequestDTO;
import com.sam.userService.dto.response.LoginResponseDTO;
import com.sam.userService.dto.response.UserResponseDTO;
import com.sam.userService.dto.response.UserRoleResponseDto;
import com.sam.userService.entity.User;
import com.sam.userService.entity.UserRole;
import com.sam.userService.repository.UserRepository;
import com.sam.userService.repository.UserRoleRepository;
import com.sam.userService.utils.GlobalUtility;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.sam.userService.utils.GlobalConstants.*;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;
    private AuthenticationManager authenticationManager;
    private GlobalUtility globalUtility;

    @Override
    @Transactional
    public String createUser(UserRequestDTO userRequestDTO) {
        validateUserRequestDto(userRequestDTO);

        Set<UserRole> userRoles = new HashSet<>();

        for (String roleName : userRequestDTO.getUserRoles()) {
            UserRole role = userRoleRepository.findByName(roleName)
                    .orElseThrow(() -> new UserRoleNotFoundException(USER_ROLE_NOT_FOUND + roleName));
            userRoles.add(role);
        }

        User user = modelMapper.map(userRequestDTO, User.class);
        user.setUserRoles(userRoles);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        userRepository.saveAndFlush(user);
        return USER_REGISTERED;
    }

    private void validateUserRequestDto(UserRequestDTO userRequestDTO) {
        validateUserNameExistsAlready(userRequestDTO.getUsername());
        validateUserEmailExistsAlready(userRequestDTO.getEmail());

    }

    private void validateUserEmailExistsAlready(String email) {
        if (userRepository.findByEmail(email).isPresent())
            throw new UserEmailAlreadyExist(USER_EMAIL_EXIST);
    }

    private void validateUserNameExistsAlready(String username) {
        if (userRepository.findByUsername(username).isPresent())
            throw new UserNameAlreadyExist(USER_NAME_EXIST);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(USER_NOT_FOUND + userId));
        return convertToUserWithRolesDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsersWithRoles() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToUserWithRolesDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        return LoginResponseDTO.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .jwtToken(globalUtility.generateJwtToken(authentication))
                .build();
    }


    private UserResponseDTO convertToUserWithRolesDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .createdBy(user.getCreatedBy())
                .updatedAt(user.getUpdatedAt())
                .updatedBy(user.getUpdatedBy())
                .userRoleResponseDto(new HashSet<>(user.getUserRoles()).stream()
                        .map(ur -> modelMapper.map(ur, UserRoleResponseDto.class)).collect(Collectors.toSet()))
                .build();
    }
}
