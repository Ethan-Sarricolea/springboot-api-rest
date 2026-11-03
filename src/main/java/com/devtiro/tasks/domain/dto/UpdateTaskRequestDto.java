package com.devtiro.tasks.domain.dto;

import com.devtiro.tasks.domain.TaskPriority;
import com.devtiro.tasks.domain.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(
        @NotBlank(message = "Title must be between 1 and 255 characters")
        @Length(max = 255, message = "Title must be between 1 and 255 characters")
        String title,

        @Length(max = 1000, message = "Description must be at most 1000 characters")
        String description,

        @FutureOrPresent(message = "Due date must be in the future")
        LocalDate dueDate,

        @NotNull(message = "Task status must be provided")
        TaskStatus status,

        @NotNull(message = "Task priority must be provided")
        TaskPriority priority
) {
}
