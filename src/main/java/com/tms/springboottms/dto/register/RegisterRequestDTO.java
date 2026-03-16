package com.tms.springboottms.dto.register;


import com.tms.springboottms.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RegisterRequestDTO {

    @NotBlank(message = "username is required")
    private  String username;

    @NotBlank(message = "password is required")
    private  String password;

    private Role role;
}
