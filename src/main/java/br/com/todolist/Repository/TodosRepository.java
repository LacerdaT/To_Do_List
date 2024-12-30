package br.com.todolist.Repository;

import br.com.todolist.Model.TodosModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface  TodosRepository extends JpaRepository<TodosModel, UUID> {
}