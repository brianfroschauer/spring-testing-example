package com.example.initializr.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Entity not found");
    }
}
