package com.sam.productService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductItemCSVDTO {

    private String productName;
    private String itemName;
    private Integer itemQuantity;
}
