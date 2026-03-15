package com.tms.springboottms.dto.task;

import com.tms.springboottms.entity.type.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDTO {
    @NotBlank(message = "Title is required")
    private  String title;

    @NotBlank(message = "Description is required")
    private  String description;


    private Status status;

    @NotNull
    private long assignedUserId;

    @NotNull
    private long createdByUserId;

}
