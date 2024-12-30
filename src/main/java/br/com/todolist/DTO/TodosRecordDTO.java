package br.com.todolist.DTO;

import br.com.todolist.Model.PriorityRole;

public record TodosRecordDTO(String name,
                             String description,
                             PriorityRole priority,
                             boolean completed) {
}

