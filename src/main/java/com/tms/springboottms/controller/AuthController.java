package com.tms.springboottms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.springboottms.dto.login.LoginRequestDTO;
import com.tms.springboottms.dto.login.LoginResponseDTO;
import com.tms.springboottms.dto.register.RegisterRequestDTO;
import com.tms.springboottms.dto.register.RegisterResponseDTO;
import com.tms.springboottms.service.AuthService;
import com.tms.springboottms.utils.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ApiResponse<String> login(@Valid @RequestBody LoginRequestDTO request) {
        return new ApiResponse<>(200, authService.login(request));
    }

    @PostMapping("/register")
    public ApiResponse<RegisterResponseDTO> login(@Valid @RequestBody RegisterRequestDTO request) {
        return new ApiResponse<>(200, authService.register(request));
    }
}
