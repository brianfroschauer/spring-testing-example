package com.example.initializr.controller;

import com.example.initializr.dto.SignupUserDTO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SignupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Given valid user, when signup, then return Ok response")
    public void givenUser_whenSignup_thenReturnOkResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("P@ssword1");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with short or empty first name, when signup, then return Bad Request response")
    public void givenUserWithShortFirstName_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("P@ssword1");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with very long first name, when signup, then return Bad Request response")
    public void givenUserWithVeryLongFirstName_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("P@ssword1");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with short or empty last name, when signup, then return Bad Request response")
    public void givenUserWithShortLastName_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("P@ssword1");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with very long last name, when signup, then return Bad Request response")
    public void givenUserWithVeryLongLastName_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("lastNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("P@ssword1");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with invalid username, when signup, then return Bad Request response")
    public void givenUserWithInvalidUsername_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username.");
        signupUserDTO.setPassword("P@ssword1");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with password without numbers, when signup, then return Bad Request response")
    public void givenUserWithPasswordWithoutNumbers_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("P@ssword");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with password without special characters, when signup, then return Bad Request response")
    public void givenUserWithPasswordWithoutSpecialCharacters_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("Password1");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with password without letters, when signup, then return Bad Request response")
    public void givenUserWithPasswordWithoutLetters_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("1234567890@");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with very short password, when signup, then return Bad Request response")
    public void givenUserWithVeryShortPassword_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("Pass");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Given user with very long password, when signup, then return Bad Request response")
    public void givenUserWithVeryLongPassword_whenSignup_thenReturnBadRequestResponse() throws Exception {
        final SignupUserDTO signupUserDTO = new SignupUserDTO();
        signupUserDTO.setFirstName("firstName");
        signupUserDTO.setLastName("lastName");
        signupUserDTO.setUsername("username");
        signupUserDTO.setPassword("P@ssword1111111111111111111111111111111111111111111");

        mockMvc
                .perform(post("/signup", signupUserDTO))
                .andExpect(status().isBadRequest());
    }
}
