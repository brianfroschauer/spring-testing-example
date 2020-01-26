package com.example.demo.exception;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException() {
        super("Entity already exists");
    }
}
