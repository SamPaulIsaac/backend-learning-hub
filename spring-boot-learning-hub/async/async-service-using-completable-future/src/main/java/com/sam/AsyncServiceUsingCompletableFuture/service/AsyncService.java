package com.sam.AsyncServiceUsingCompletableFuture.service;


import com.sam.AsyncServiceUsingCompletableFuture.dto.PostDto;
import com.sam.AsyncServiceUsingCompletableFuture.dto.UserDto;
import com.sam.AsyncServiceUsingCompletableFuture.exception.CustomRuntimeException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<UserDto>   fetchUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2000); // Simulate a delay (e.g., calling an external API)
            return UserDto.builder()
                    .name("John")
                    .age(30)
                    .build();
        });
    }

    @Async
    public CompletableFuture<PostDto> fetchUserPosts() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(3000); // Simulate a delay (e.g., fetching data from the database)
            return PostDto.builder()
                    .name(Arrays.asList("Post 1", "Post 2", "Post 3"))
                    .build();
        });
    }

    @Async
    public CompletableFuture<PostDto> fetchUserPostsThrowsException() {
        return CompletableFuture.supplyAsync(() -> {
            throw new CustomRuntimeException("This is a sample custom runtime exception");
        });
          }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}

