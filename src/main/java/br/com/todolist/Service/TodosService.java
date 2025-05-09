package br.com.todolist.Service;

import br.com.todolist.Model.TodosModel;
import br.com.todolist.Repository.TodosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.domain.Sort.by;

@Service
public class TodosService {

    public TodosRepository todosRepository;

    public TodosService(TodosRepository todosRepository) {

        this.todosRepository = todosRepository;
    }

    public TodosModel create(TodosModel todosModel){

        return todosRepository.save(todosModel);
    }


    public List<TodosModel> list(){
        Sort sort = Sort.by("priority").descending().and(by("completed").descending());
        Pageable pageable = PageRequest.of(0, 2, sort);
        Page<TodosModel> page = todosRepository.findAll(pageable);
        return page.getContent();
    }

    public Optional<TodosModel> listId(UUID id){

        return todosRepository.findById(id);
    }

    public TodosModel update(TodosModel todosModel) {

        return todosRepository.save(todosModel);
    }


    public List<TodosModel> delete(UUID id){
        todosRepository.deleteById(id);
        return list();
    }
}
