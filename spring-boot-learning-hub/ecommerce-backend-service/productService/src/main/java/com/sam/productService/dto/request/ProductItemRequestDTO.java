package com.sam.productService.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductItemRequestDTO {
    private Long id;
    private String name;
    private Integer quantity;
}
