package com.tms.springboottms.service.impl;

import org.springframework.stereotype.Service;

import com.tms.springboottms.dto.login.LoginRequestDTO;
import com.tms.springboottms.dto.login.LoginResponseDTO;
import com.tms.springboottms.dto.register.RegisterRequestDTO;
import com.tms.springboottms.dto.register.RegisterResponseDTO;
import com.tms.springboottms.service.AuthService;

@Service
public class AuthServiceImpl  implements AuthService{

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}
