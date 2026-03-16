package com.tms.springboottms.dto.register;

import com.tms.springboottms.entity.User;
import com.tms.springboottms.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDTO {
    
    private Long id;
    private String username;
    private Role role;

    public RegisterResponseDTO(User savedUser) {
        this.id = savedUser.getId();
        this.username = savedUser.getUsername();
        this.role = savedUser.getRole();
    }
}
