package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private HttpStatus status;
    private String message;
    private Date timestamp;

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
