package com.tms.springboottms.dto.login;

import com.tms.springboottms.entity.User;

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

     public LoginResponseDTO(long id, String username, String token ) {
        this.id = id;
        this.username = username;
        this.token = token;
    }
}
