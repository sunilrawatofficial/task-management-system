package com.tms.springboottms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tms.springboottms.dto.task.TaskRequestDTO;
import com.tms.springboottms.dto.task.TaskResponseDTO;
import com.tms.springboottms.entity.Task;
import com.tms.springboottms.entity.User;
import com.tms.springboottms.repository.TaskRepository;
import com.tms.springboottms.repository.UserRepository;
import com.tms.springboottms.service.TaskService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO requestDTO) {

        User assignedUser = userRepository.findById(requestDTO.getAssignedUserId())
                .orElseThrow(() -> new EntityNotFoundException("Assigned User Not Found"));

        User createdByUser = userRepository.findById(requestDTO.getCreatedByUserId())
                .orElseThrow(() -> new EntityNotFoundException("createdByUser User Not Found"));


        Task task = new Task();

        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setStatus(requestDTO.getStatus());
        task.setAssignedTo(assignedUser);
        task.setCreatedBy(createdByUser);
        taskRepository.save(task);

        return new TaskResponseDTO(task);

    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskResponseDTO::new)
                .toList();
    }

    @Override
    public TaskResponseDTO getByTaskId(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new EntityNotFoundException("Task not found"));
        return  new TaskResponseDTO(task);

    }

    @Override
    public TaskResponseDTO updateTask(Long taskId, TaskRequestDTO requestDTO) {

        Task existingTask = taskRepository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("Task not found"));

        existingTask.setTitle(requestDTO.getTitle());
        existingTask.setDescription(requestDTO.getDescription());
        existingTask.setStatus(requestDTO.getStatus());

        Task saved =  taskRepository.save(existingTask);
        return new TaskResponseDTO(saved);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        taskRepository.findById(taskId).orElseThrow(()-> new EntityNotFoundException("Task not found"));
        taskRepository.deleteById(taskId);
    }
}
