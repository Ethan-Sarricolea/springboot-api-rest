package com.devtiro.tasks.domain.dto;

import com.devtiro.tasks.domain.TaskPriority;
import com.devtiro.tasks.domain.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
