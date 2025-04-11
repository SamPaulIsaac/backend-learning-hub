package com.sam.userService.config.exception;

public class UserNameAlreadyExist extends RuntimeException {
    public UserNameAlreadyExist(String message) {
        super(message);
    }
}
