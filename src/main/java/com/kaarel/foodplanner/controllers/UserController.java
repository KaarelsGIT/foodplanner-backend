package com.kaarel.foodplanner.controllers;

import com.kaarel.foodplanner.dtos.UserDTO;
import com.kaarel.foodplanner.dtos.UserRegistrationDTO;
import com.kaarel.foodplanner.models.User;
import com.kaarel.foodplanner.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserRegistrationDTO registrationDTO) {
        User user = User.builder()
                .username(registrationDTO.getUsername())
                .password(registrationDTO.getPassword())
                .roles(registrationDTO.getRoles())
                .build();

        User savedUser = userService.register(user);

        UserDTO userDTO = UserDTO.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .roles(savedUser.getRoles())
                .build();

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers().stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .roles(user.getRoles())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();
        return ResponseEntity.ok(userDTO);
    }

}
