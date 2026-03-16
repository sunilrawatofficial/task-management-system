package com.tms.springboottms.service;

import org.springframework.stereotype.Service;

import com.tms.springboottms.dto.login.LoginRequestDTO;
import com.tms.springboottms.dto.login.LoginResponseDTO;
import com.tms.springboottms.dto.register.RegisterRequestDTO;
import com.tms.springboottms.dto.register.RegisterResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO);
}
