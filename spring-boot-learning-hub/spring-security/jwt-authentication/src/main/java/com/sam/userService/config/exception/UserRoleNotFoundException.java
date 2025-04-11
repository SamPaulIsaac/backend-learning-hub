package com.sam.userService.config.exception;


public class UserRoleNotFoundException extends RuntimeException {

    public UserRoleNotFoundException(String message) {
        super(message);
    }
}
