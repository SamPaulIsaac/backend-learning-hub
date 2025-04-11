package com.sam.AsyncServiceUsingCompletableFuture.controller;

import com.sam.AsyncServiceUsingCompletableFuture.dto.ErrorResponseDto;
import com.sam.AsyncServiceUsingCompletableFuture.dto.PostDto;
import com.sam.AsyncServiceUsingCompletableFuture.dto.SuccessResponseDto;
import com.sam.AsyncServiceUsingCompletableFuture.dto.UserDto;
import com.sam.AsyncServiceUsingCompletableFuture.exception.CustomRuntimeException;
import com.sam.AsyncServiceUsingCompletableFuture.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/user-details")
    public ResponseEntity<SuccessResponseDto> getUserDetails() throws ExecutionException, InterruptedException {
        CompletableFuture<UserDto> userDetailsFuture = asyncService.fetchUserDetails();
        CompletableFuture<PostDto> userPostsFuture = asyncService.fetchUserPosts();

        SuccessResponseDto result = userDetailsFuture
                .thenCombine(userPostsFuture, (userDetails, userPosts) ->
                        SuccessResponseDto.builder()
                                .userDto(userDetails)
                                .postDto(userPosts)
                                .build())
                .get();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/user-details-exception")
    public ResponseEntity<?> getUserDetailsWithExceptionHandling() {
        try {
            CompletableFuture<UserDto> userDetailsFuture = asyncService.fetchUserDetails();
            CompletableFuture<PostDto> userPostsFuture = asyncService.fetchUserPostsThrowsException();

            SuccessResponseDto result = userDetailsFuture
                    .thenCombine(userPostsFuture, (userDetails, userPosts) ->
                            SuccessResponseDto.builder()
                                    .userDto(userDetails)
                                    .postDto(userPosts)
                                    .build())
                    .get();

            return ResponseEntity.ok(result);

        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof CustomRuntimeException) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(ErrorResponseDto.builder()
                                .errorMessage(cause.getMessage())
                                .build());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorResponseDto.builder()
                            .errorMessage("An error occurred during async processing: " + cause.getMessage())
                            .build());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorResponseDto.builder()
                            .errorMessage("Interrupted during async processing: " + e.getMessage())
                            .build());
        }
    }
}
