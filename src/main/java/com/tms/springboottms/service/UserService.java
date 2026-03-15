package com.tms.springboottms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tms.springboottms.dto.user.CreateUserDTO;
import com.tms.springboottms.dto.user.UserResponseDTO;

@Service
public interface  UserService {

    public UserResponseDTO createUser(CreateUserDTO request);

    public List<UserResponseDTO> getUsers();

    public UserResponseDTO getUser(Long id);

    public void deleteUser(Long id);
}
