package br.com.todolist.DTO;

import java.util.UUID;

public record TodosRecordDTO(String nome,
                             String descricao,
                             int prioridade,
                             boolean realizado) {
}
