package com.sam.userService.utils;

import java.time.LocalDateTime;

public class GlobalConstants {

    public static final String ERROR_MESSAGE = "An error occurred in user service: ";
    public static final String JWT_ERROR_MESSAGE = "An error occurred during jwt token validation: ";
    public static final String FILTER_ERROR_MESSAGE = "An error occurred during doFilterInternal: ";

    public static final String USER_NOT_FOUND = "User is not found for the requested: ";

    public static final String USER_ROLE_NOT_FOUND = "User Role not found for the requested: ";

    public static final String USER_REGISTERED = "User has been registered successfully.";

    public static final String USER_EMAIL_EXIST = "User Email Already Exist.";

    public static final String USER_NAME_EXIST = "User Name Already Exist.";

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";

    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static String getUser() {
        return "SYSTEM_ADMIN";
    }
}
