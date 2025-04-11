package com.sam.beanCreationApplicationStart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;


    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + '}';
    }
}

