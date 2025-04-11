package com.sam.orderService.config.exception;

public class CsvFileEmptyException extends RuntimeException {
    public CsvFileEmptyException(String message) {
        super(message);
    }
}
