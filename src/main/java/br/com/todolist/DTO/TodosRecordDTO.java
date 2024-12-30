package br.com.todolist.DTO;

public record TodosRecordDTO(String name,
                             String description,
                             int priority,
                             boolean completed) {
}

