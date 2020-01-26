package com.example.initializr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupUserDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
