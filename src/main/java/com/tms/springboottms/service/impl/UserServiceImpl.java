package com.tms.springboottms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tms.springboottms.dto.user.CreateUserDTO;
import com.tms.springboottms.dto.user.UserResponseDTO;
import com.tms.springboottms.entity.User;
import com.tms.springboottms.repository.UserRepository;
import com.tms.springboottms.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private  final UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(CreateUserDTO request) {
       User user = new User();
       user.setUsername(request.username());
       user.setPassword(request.password());
       User savedUser = userRepository.save(user);

       return new UserResponseDTO(savedUser);
    }

    @Override
    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll()
            .stream()
            .map(UserResponseDTO::new)
            .toList();
    }

    @Override
    public UserResponseDTO getUser(Long id) {
        User savedUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return new UserResponseDTO(savedUser);
    }


    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
