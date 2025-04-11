package com.sam.productService.config.exception;

public class ProductNameAlreadyExist extends RuntimeException {
    public ProductNameAlreadyExist(String message) {
        super(message);
    }
}
