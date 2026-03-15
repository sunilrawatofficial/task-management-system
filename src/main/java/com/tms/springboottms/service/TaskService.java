package com.tms.springboottms.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tms.springboottms.dto.task.TaskRequestDTO;
import com.tms.springboottms.dto.task.TaskResponseDTO;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);

    List<TaskResponseDTO> getAllTasks();

    Page<TaskResponseDTO> getTasksWithPagination(int page, int size);

    TaskResponseDTO getByTaskId(Long taskId);

    TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO);

    void deleteTaskById(Long id);
}

