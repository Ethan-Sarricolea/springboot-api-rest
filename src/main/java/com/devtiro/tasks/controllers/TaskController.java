package com.devtiro.tasks.controllers;

import com.devtiro.tasks.domain.dto.CreateTaskRequestDto;
import com.devtiro.tasks.domain.dto.TaskDto;
import com.devtiro.tasks.domain.dto.UpdateTaskRequestDto;
import com.devtiro.tasks.domain.entities.Task;
import com.devtiro.tasks.mappers.TaskMapper;
import com.devtiro.tasks.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDto dto) {
        Task task = taskService.createTask(taskMapper.fromDto(dto));
        return new ResponseEntity<>(taskMapper.toDto(task), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks() {
        List<TaskDto> tasks = taskService.listTasks().stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable UUID taskId,
                                              @Valid @RequestBody UpdateTaskRequestDto dto) {
        Task task = taskService.updateTask(taskId, taskMapper.fromDto(dto));
        return ResponseEntity.ok(taskMapper.toDto(task));
    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
