package com.sam.userService.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.sam.userService.utils.GlobalConstants.ERROR_MESSAGE;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNameAlreadyExist.class)
    public ResponseEntity<String> handleUserNameAlreadyExistException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(UserEmailAlreadyExist.class)
    public ResponseEntity<String> handleUserEmailAlreadyExistException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(UserRoleNotFoundException.class)
    public ResponseEntity<String> handleUserRoleNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getLocalizedMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getLocalizedMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ERROR_MESSAGE + exception.getMessage());
    }

}
