package com.sam.productService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    private Long id;
    private String name;
    private List<ProductItemRequestDTO> productItemRequestDTOList;
}
