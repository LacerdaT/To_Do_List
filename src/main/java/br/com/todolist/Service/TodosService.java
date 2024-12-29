package br.com.todolist.Service;

import br.com.todolist.Model.Todos;
import br.com.todolist.Repository.TodosRepository;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.domain.Sort.by;


public class TodosService {

    public TodosRepository todosRepository;

    public TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public List<Todos> create(Todos todos){
        todosRepository.save(todos);
        return list();
    }

    public List<Todos> list(){
        Sort sort = Sort.by("prioridades").descending().and(by("nome").ascending());
       return todosRepository.findAll(sort);
    }

    public List<Todos> update(Todos todos){
        todosRepository.save(todos);
        return list();
    }

    public List<Todos> delete(UUID id){
        todosRepository.deleteById(id);
        return list();
    }
}
