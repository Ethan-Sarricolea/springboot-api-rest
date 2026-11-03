package com.devtiro.tasks.services;

import com.devtiro.tasks.domain.CreateTaskRequest;
import com.devtiro.tasks.domain.UpdateTaskRequest;
import com.devtiro.tasks.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
