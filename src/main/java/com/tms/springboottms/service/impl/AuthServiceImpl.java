package com.tms.springboottms.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tms.springboottms.config.JwtService;
import com.tms.springboottms.dto.login.LoginRequestDTO;
import com.tms.springboottms.dto.login.LoginResponseDTO;
import com.tms.springboottms.dto.register.RegisterRequestDTO;
import com.tms.springboottms.dto.register.RegisterResponseDTO;
import com.tms.springboottms.entity.User;
import com.tms.springboottms.repository.UserRepository;
import com.tms.springboottms.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository  userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        String username = loginRequestDTO.getUsername();
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                username,
                loginRequestDTO.getPassword()
            )
        );
        return new LoginResponseDTO(userRepository.findByUsername(username).get().getId(), username, jwtService.generateToken(username));
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO) {

        if(userRepository.existsByUsername(registerRequestDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User newUser = new User();
        newUser.setUsername(registerRequestDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        newUser.setRole(registerRequestDTO.getRole());
        User savedUser = userRepository.save(newUser);

        return new RegisterResponseDTO(savedUser);
    }

}
