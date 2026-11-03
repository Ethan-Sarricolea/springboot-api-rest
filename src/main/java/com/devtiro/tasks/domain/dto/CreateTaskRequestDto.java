package com.devtiro.tasks.domain.dto;

import com.devtiro.tasks.domain.TaskPriority;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreateTaskRequestDto(
        @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
        @Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
        String title,

        @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
        String description,

        @FutureOrPresent(message = "Due date must be in the future")
        LocalDate dueDate,

        @NotNull(message = "Task priority must be provided")
        TaskPriority priority
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH =
            "Title must be between 1 and 255 characters";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
            "Description must be at most 1000 characters";
}
