package br.com.todolist.Repository;

import br.com.todolist.Model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface  TodosRepository extends JpaRepository<Todos, UUID> {

}
