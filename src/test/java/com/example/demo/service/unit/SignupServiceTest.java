package com.example.demo.service.unit;

import com.example.demo.entity.User;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.signup.SignupService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class SignupServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SignupService signupService;

    @Test
    public void contextLoads() {
        assertNotNull(encoder);
        assertNotNull(signupService);
    }

    @Test
    @DisplayName("Given user, when signup, then return user")
    public void givenUser_whenSignup_thenReturnUser() {
        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        doReturn(user)
                .when(userRepository)
                .save(user);

        assertNotNull(signupService.signup(user));
        verify(userRepository).save(user);
    }

    @Test
    @DisplayName("Given user with an username that already exists, when signup, then throw already exists exception")
    public void givenUserWithUsernameThatAlreadyExists_whenSignup_thenThrowAlreadyExistsException() {
        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        doReturn(Optional.of(user))
                .when(userRepository)
                .findByUsername("username");

        assertThrows(AlreadyExistsException.class, () -> signupService.signup(user));
    }

    @Test
    @DisplayName("Given user, when signup, then encode password")
    public void givenUser_whenSignup_thenEncodePassword() {
        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        doReturn(user)
                .when(userRepository)
                .save(user);

        assertNotNull(signupService.signup(user));
        assertTrue(encoder.matches("password", user.getPassword()));
    }
}
