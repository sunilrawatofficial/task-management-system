package com.tms.springboottms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.springboottms.dto.task.TaskRequestDTO;
import com.tms.springboottms.dto.task.TaskResponseDTO;
import com.tms.springboottms.service.TaskService;
import com.tms.springboottms.utils.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ApiResponse<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO dto) {
        return new ApiResponse<>(201, taskService.createTask(dto));
    }

    @GetMapping
    public ApiResponse<List<TaskResponseDTO>> getTasks() {
        return new ApiResponse<>(201, taskService.getAllTasks());
    }



    @GetMapping("/{taskId}")
    public ApiResponse<TaskResponseDTO> getTask(@PathVariable Long taskId) {
        return new ApiResponse<>(200, taskService.getByTaskId(taskId));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
        return ResponseEntity.noContent().build();
    }
}
