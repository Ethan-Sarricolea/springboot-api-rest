package com.devtiro.tasks.mappers;

import com.devtiro.tasks.domain.CreateTaskRequest;
import com.devtiro.tasks.domain.UpdateTaskRequest;
import com.devtiro.tasks.domain.dto.CreateTaskRequestDto;
import com.devtiro.tasks.domain.dto.TaskDto;
import com.devtiro.tasks.domain.dto.UpdateTaskRequestDto;
import com.devtiro.tasks.domain.entities.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
