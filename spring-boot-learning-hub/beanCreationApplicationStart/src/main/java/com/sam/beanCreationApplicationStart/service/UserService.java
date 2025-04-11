package com.sam.beanCreationApplicationStart.service;

import com.sam.beanCreationApplicationStart.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")  // Prototype scope
public class UserService {
    public User createUser(String name, int age) {
        return new User(name, age);
    }
}

