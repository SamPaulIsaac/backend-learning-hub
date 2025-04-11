package com.sam.beanCreationApplicationStart.controller;

import com.sam.beanCreationApplicationStart.entity.User;
import com.sam.beanCreationApplicationStart.entity.UserRequestDTO;
import com.sam.beanCreationApplicationStart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRequestDTO userRequest;
    private final UserService userService;

    @Autowired
    public UserController(UserRequestDTO userRequest, UserService userService) {
        this.userRequest = userRequest;
        this.userService = userService;
    }

    // POST endpoint to create a user from request data
    @PostMapping
    public ResponseEntity<String> createUser(@RequestParam String name, @RequestParam int age) {
        userRequest.setName(name);
        userRequest.setAge(age);

        // Create a new user using the prototype-scoped service
        User newUser = userService.createUser(userRequest.getName(), userRequest.getAge());

        // Here you can return the user info as response
        return ResponseEntity.ok("Created: " + newUser);
    }

    // GET endpoint to retrieve the current user request data
    @GetMapping
    public ResponseEntity<UserRequestDTO> getUserRequest() {
        return ResponseEntity.ok(userRequest);
    }
}

