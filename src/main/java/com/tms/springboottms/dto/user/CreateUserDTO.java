package com.tms.springboottms.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
        @NotBlank(message = "username is required")
        String username,

        @NotBlank
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password
) {}
