package com.tms.springboottms.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.springboottms.dto.user.CreateUserDTO;
import com.tms.springboottms.dto.user.UserResponseDTO;
import com.tms.springboottms.service.impl.UserServiceImpl;
import com.tms.springboottms.utils.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ApiResponse<UserResponseDTO> createUser(@Valid @RequestBody CreateUserDTO request) {
        return new ApiResponse<>(201, userService.createUser(request));
    }

    @GetMapping
    public ApiResponse<List<UserResponseDTO>> getUsers() {
        return new ApiResponse<>(200, userService.getUsers());
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponseDTO> getUser(@PathVariable Long userId) {
        return new ApiResponse<>(200, userService.getUser(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
