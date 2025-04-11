package com.sam.userService.service;


import com.sam.userService.dto.request.LoginRequestDTO;
import com.sam.userService.dto.request.UserRequestDTO;
import com.sam.userService.dto.response.LoginResponseDTO;
import com.sam.userService.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    String createUser(UserRequestDTO user);

    void deleteUser(Long userId);

    UserResponseDTO getUserById(Long userId);

    List<UserResponseDTO> getAllUsersWithRoles();

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
