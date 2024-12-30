package br.com.todolist.DTO;

import br.com.todolist.Model.PriorityRole;
import jakarta.validation.constraints.NotBlank;

public record TodosRecordDTO(@NotBlank String name,
                             @NotBlank String description,
                             PriorityRole priority,
                             boolean completed) {
}

