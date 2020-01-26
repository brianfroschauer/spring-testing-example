package com.example.initializr.controller;

import com.example.initializr.dto.SignupUserDTO;
import com.example.initializr.dto.UserDTO;
import com.example.initializr.entity.User;
import com.example.initializr.service.signup.SignupService;
import com.example.initializr.util.ObjectMapper;
import com.example.initializr.util.ObjectMapperImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("signup")
public class SignupController {

    private final SignupService signupService;
    private final ObjectMapper objectMapper;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
        this.objectMapper = new ObjectMapperImpl();
    }

    @PostMapping
    public ResponseEntity<UserDTO> signup(@RequestBody @Valid SignupUserDTO signupUser) {
        final User user = signupService.signup(objectMapper.map(signupUser, User.class));
        return ResponseEntity.ok(objectMapper.map(user, UserDTO.class));
    }
}
