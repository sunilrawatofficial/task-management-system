package com.tms.springboottms.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class LoginResponseDTO {
    private Long id;
    private  String username;
    private  String token;
}
