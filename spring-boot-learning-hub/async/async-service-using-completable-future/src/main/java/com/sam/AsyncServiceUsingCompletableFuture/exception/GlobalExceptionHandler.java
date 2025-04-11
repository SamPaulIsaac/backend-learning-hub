package com.sam.AsyncServiceUsingCompletableFuture.exception;


import com.sam.AsyncServiceUsingCompletableFuture.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomRuntimeException(CustomRuntimeException ex, WebRequest request) {
        System.out.println("CRT Request: "+request.getContextPath());
        System.out.println("CRT USER: "+request.getRemoteUser());
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessage("A custom runtime error occurred: " + ex.getLocalizedMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleRuntimeException(RuntimeException ex, WebRequest request) {
        System.out.println("RTE Request: "+request.getContextPath());
        System.out.println("RTE USER: "+request.getRemoteUser());
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessage("A runtime error occurred: " + ex.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorMessage("An unexpected error occurred: " + ex.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
