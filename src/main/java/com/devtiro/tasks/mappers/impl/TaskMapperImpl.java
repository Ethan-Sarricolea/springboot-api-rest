package com.devtiro.tasks.mappers.impl;

import com.devtiro.tasks.domain.CreateTaskRequest;
import com.devtiro.tasks.domain.UpdateTaskRequest;
import com.devtiro.tasks.domain.dto.CreateTaskRequestDto;
import com.devtiro.tasks.domain.dto.TaskDto;
import com.devtiro.tasks.domain.dto.UpdateTaskRequestDto;
import com.devtiro.tasks.domain.entities.Task;
import com.devtiro.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(dto.title(), dto.description(), dto.dueDate(), dto.priority());
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(dto.title(), dto.description(), dto.dueDate(), dto.status(), dto.priority());
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription(),
                task.getDueDate(), task.getPriority(), task.getStatus());
    }
}
