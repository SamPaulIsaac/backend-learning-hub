package com.sam.userdetailservice.controller;

import com.sam.userdetailservice.entity.Role;
import com.sam.userdetailservice.entity.User;
import com.sam.userdetailservice.repository.RoleRepository;
import com.sam.userdetailservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/")
@Slf4j
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        log.info("Request received for ADMIN API.");
        return ResponseEntity.ok("Welcome Admin.");
    }

    @GetMapping("/hr")
    public ResponseEntity<String> hr() {
        log.info("Request received for HR API.");
        return ResponseEntity.ok("Welcome HR.");
    }

    @GetMapping("/manager")
    public ResponseEntity<String> manager() {
        log.info("Request received for MANAGER API.");
        return ResponseEntity.ok("Welcome Manager.");
    }

    @GetMapping("/employee")
    public ResponseEntity<String> employee() {
        log.info("Request received for EMPLOYEE API.");
        return ResponseEntity.ok("Welcome Employee.");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User request) {
        log.info("Request received for REGISTER USER: " + request);
        for (Role role : request.getRoles())
            roleRepository.save(role);
        User newUser = User.builder().username(request.getUsername()).password(passwordEncoder.encode(request.getPassword())).roles(request.getRoles()).build();
        userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully.");
    }
}
