package com.example.initializr.controller;

import com.example.initializr.dto.UpdateUserDTO;
import com.example.initializr.dto.UserDTO;
import com.example.initializr.entity.User;
import com.example.initializr.service.user.UserService;
import com.example.initializr.util.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    public UserController(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> find() {
        final List<User> users = userService.find();
        return ResponseEntity.ok(objectMapper.map(users, UserDTO.class));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> find(@PathVariable Long id) {
        final User users = userService.find(id);
        return ResponseEntity.ok(objectMapper.map(users, UserDTO.class));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id,
                                          @RequestBody @Valid UpdateUserDTO updateUserDTO) {
        final User user = userService.update(id, objectMapper.map(updateUserDTO, User.class));
        return ResponseEntity.ok(objectMapper.map(user, UserDTO.class));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
