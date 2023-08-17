package com.taskmanagement.TaskManagementSystem.controller;

import com.taskmanagement.TaskManagementSystem.dto.TaskDTO;
import com.taskmanagement.TaskManagementSystem.entity.Task;
import com.taskmanagement.TaskManagementSystem.service.impl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskServiceImpl taskService;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskDTO taskDTO) {
        taskService.createTask(taskDTO);
        System.out.println("Task created.");
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{taskId}/complete")
    public ResponseEntity<Void> markTaskAsCompleted(@PathVariable Long taskId) {
        taskService.markTaskAsCompleted(taskId);
        System.out.println("Task completed. Congratulations!");
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> taskDTOs = taskService.getAllTasks();
        return ResponseEntity.ok(taskDTOs);
    }
}