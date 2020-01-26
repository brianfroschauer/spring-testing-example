package com.example.demo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Entity not found");
    }
}
