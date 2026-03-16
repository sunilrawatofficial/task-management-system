package com.tms.springboottms.dto.login;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginRequestDTO {
    private  String username;
    private  String password;
}
