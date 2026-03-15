package com.tms.springboottms.dto.user;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tms.springboottms.entity.User;

import lombok.Getter;

@Getter
@JsonPropertyOrder({ "id", "username", "createdDate" })
public class  UserResponseDTO {

  private final Long id;
  private final String username;
  private final LocalDateTime createdDate;

  public UserResponseDTO(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.createdDate = user.getCreatedAt();
  }
}
