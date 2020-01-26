package com.example.initializr.exception;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException() {
        super("Entity already exists");
    }
}
