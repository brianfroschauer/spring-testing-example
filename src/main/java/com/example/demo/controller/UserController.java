package com.example.demo.controller;

import com.example.demo.dto.UpdateUserDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;
import com.example.demo.util.ObjectMapper;
import com.example.demo.util.ObjectMapperImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    public UserController(UserService userService) {
        this.userService = userService;
        this.objectMapper = new ObjectMapperImpl();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> find() {
        final List<User> users = userService.find();
        return ResponseEntity.ok(objectMapper.map(users, UserDTO.class));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> find(@PathVariable Long id) {
        final User user = userService.find(id);
        return ResponseEntity.ok(objectMapper.map(user, UserDTO.class));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id,
                                          @RequestBody @Valid UpdateUserDTO updateUserDTO) {
        final User user = userService.update(id, objectMapper.map(updateUserDTO, User.class));
        return ResponseEntity.ok(objectMapper.map(user, UserDTO.class));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
