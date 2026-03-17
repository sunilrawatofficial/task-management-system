package com.tms.springboottms.service;

import com.tms.springboottms.dto.login.LoginRequestDTO;
import com.tms.springboottms.dto.register.RegisterRequestDTO;
import com.tms.springboottms.dto.register.RegisterResponseDTO;

public interface AuthService {
    String login(LoginRequestDTO loginRequestDTO);

    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO);
}
