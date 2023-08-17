package com.taskmanagement.TaskManagementSystem.service.impl;

import com.taskmanagement.TaskManagementSystem.dto.TaskDTO;
import com.taskmanagement.TaskManagementSystem.entity.Task;
import com.taskmanagement.TaskManagementSystem.exceptions.TaskNotFoundException;
import com.taskmanagement.TaskManagementSystem.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.FetchNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl {

    private final TaskRepository taskRepository;

    public void createTask(TaskDTO taskDTO) {
        try {
            Task task = new Task();
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setDate(taskDTO.getDate());
            task.setCompleted(false);

            taskRepository.save(task);
            System.out.println(task);
        } catch (FetchNotFoundException notFoundException) {

        }
    }

    public void markTaskAsCompleted(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setCompleted(true);

            taskRepository.save(task);
            System.out.println("Task marked as completed!");
        } else {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found");
        }
    }

    public List<TaskDTO> getAllTasks() {
        List<TaskDTO> taskDTOs = taskRepository.findAll().stream().map(TaskDTO::new).toList();
        return taskDTOs;
    }
}