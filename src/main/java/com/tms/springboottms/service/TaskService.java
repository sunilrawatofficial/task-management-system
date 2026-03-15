package com.tms.springboottms.service;

import com.tms.springboottms.dto.task.TaskRequestDTO;
import com.tms.springboottms.dto.task.TaskResponseDTO;

import java.util.List;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);

    List<TaskResponseDTO> getAllTasks();

    TaskResponseDTO getByTaskId(Long taskId);

    TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO);

    void deleteTaskById(Long id);
}

