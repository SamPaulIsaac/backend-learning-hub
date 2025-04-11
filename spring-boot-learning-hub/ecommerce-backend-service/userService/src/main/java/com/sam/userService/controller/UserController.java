package com.sam.userService.controller;

import com.sam.userService.dto.request.LoginRequestDTO;
import com.sam.userService.dto.request.UserRequestDTO;
import com.sam.userService.dto.response.LoginResponseDTO;
import com.sam.userService.dto.response.UserResponseDTO;
import com.sam.userService.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@Slf4j
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public String createUser(@RequestBody UserRequestDTO userRequestDTO) {
        log.info("Requested received to register user with request body: " + userRequestDTO);
        return userService.createUser(userRequestDTO);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        log.info("Requested received to login user with request body: " + loginRequestDTO);
        return userService.login(loginRequestDTO);
    }

    @GetMapping("/getAllUsers")
    //@PreAuthorize("hasRole('admin')")
    public List<UserResponseDTO> getAllUsersWithAssociatedRoles() {
        log.info("Requested received to get all users with associated roles.");
        return userService.getAllUsersWithRoles();
    }

    @GetMapping("/{userId}")
    public UserResponseDTO getUserById(@PathVariable Long userId) {
        log.info("Requested received to get user for the id: " + userId);
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        log.info("Requested received to delete user for the id: " + userId);
        userService.deleteUser(userId);
        return "User Successfully deleted.";
    }
}

