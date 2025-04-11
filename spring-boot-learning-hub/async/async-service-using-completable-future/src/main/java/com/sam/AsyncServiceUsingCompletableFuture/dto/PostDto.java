package com.sam.AsyncServiceUsingCompletableFuture.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostDto {
    List<String> name;
}
