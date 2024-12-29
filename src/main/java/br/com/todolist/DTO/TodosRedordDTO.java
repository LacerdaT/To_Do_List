package br.com.todolist.DTO;

import java.util.UUID;

public record TodosRedordDTO(UUID id,
                             String nome,
                             String descricao,
                             int prioridade,
                             boolean realizado) {
}
