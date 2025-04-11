package com.sam.AsyncServiceUsingCompletableFuture.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessResponseDto {
    private UserDto userDto;
    private PostDto postDto;
}
