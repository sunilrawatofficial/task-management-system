package com.tms.springboottms.dto.register;


import com.tms.springboottms.enums.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequestDTO {

    @NotBlank(message = "username is required")
    private  String username;

    @NotBlank(message = "password is required")
    private  String password;

    private Role role;
}
