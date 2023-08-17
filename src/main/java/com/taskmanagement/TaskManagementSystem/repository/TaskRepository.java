package com.taskmanagement.TaskManagementSystem.repository;

import com.taskmanagement.TaskManagementSystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
