package com.sam.userService.config.exception;

public class UserEmailAlreadyExist extends RuntimeException {
    public UserEmailAlreadyExist(String message) {
        super(message);
    }
}
