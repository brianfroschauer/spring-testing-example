package com.example.initializr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handle(NotFoundException exception) {
        return handle(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ApiError> handle(AlreadyExistsException exception) {
        return handle(HttpStatus.CONFLICT, exception.getMessage());
    }

    private ResponseEntity<ApiError> handle(HttpStatus status, String message) {
        return new ResponseEntity<>(new ApiError(status, message), status);
    }
}
