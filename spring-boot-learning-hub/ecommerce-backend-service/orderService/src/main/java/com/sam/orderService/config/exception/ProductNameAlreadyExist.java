package com.sam.orderService.config.exception;

public class ProductNameAlreadyExist extends RuntimeException {
    public ProductNameAlreadyExist(String message) {
        super(message);
    }
}
