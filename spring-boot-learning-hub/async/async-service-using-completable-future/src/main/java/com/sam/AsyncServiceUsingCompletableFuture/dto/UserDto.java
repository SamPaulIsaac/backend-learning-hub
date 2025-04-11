package com.sam.AsyncServiceUsingCompletableFuture.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    String name;
    int age;
}
