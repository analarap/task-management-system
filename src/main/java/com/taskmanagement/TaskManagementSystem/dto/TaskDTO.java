package com.taskmanagement.TaskManagementSystem.dto;

import com.taskmanagement.TaskManagementSystem.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDate date;
    private boolean completed;


    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.date = task.getDate();
        this.completed = task.isCompleted();
    }
}
