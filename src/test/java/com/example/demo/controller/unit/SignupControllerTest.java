package com.example.demo.controller.unit;

import com.example.demo.controller.SignupController;
import com.example.demo.dto.SignupUserDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.signup.SignupService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SignupControllerTest {

    @MockBean
    private SignupService signupService;

    @Autowired
    private SignupController signupController;

    @Test
    public void contextLoads() {
        assertNotNull(signupController);
    }

    @Test
    @DisplayName("Given valid user, when signup, then return Ok response")
    public void givenUser_whenSignup_thenReturnOkResponse() {
        doReturn(new User())
                .when(signupService)
                .signup(any(User.class));

        final ResponseEntity<UserDTO> response = signupController.signup(new SignupUserDTO());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(signupService, times(1)).signup(any(User.class));
    }
}
