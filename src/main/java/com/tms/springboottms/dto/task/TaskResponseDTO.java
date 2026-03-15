package com.tms.springboottms.dto.task;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tms.springboottms.entity.Task;
import com.tms.springboottms.entity.type.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@JsonPropertyOrder({ "id", "title", "description", "status", "createdDate" })
public class TaskResponseDTO {

    private  Long id;
    private  String title;
    private  String description;
    private Status status;
    private LocalDateTime createdDate;

    public TaskResponseDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.createdDate = task.getCreatedAt();
    }
}
