package com.example.initializr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.example.initializr.util.Patterns.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupUserDTO {

    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @Pattern(regexp = PATTERN_USERNAME)
    private String username;

    @Pattern(regexp = PATTERN_PASSWORD)
    private String password;
}
