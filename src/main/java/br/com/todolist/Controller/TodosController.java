package br.com.todolist.Controller;

import br.com.todolist.DTO.TodosRecordDTO;
import br.com.todolist.Model.TodosModel;
import br.com.todolist.Service.TodosService;
import org.springframework.beans.BeanUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/todoslist")
public class TodosController {

    private TodosService todosService;

    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @PostMapping("/todos")
    public ResponseEntity<TodosModel> saveTodo(@RequestBody @Valid TodosRecordDTO todosRecordDTO) {
        var todosModel = new TodosModel();
        BeanUtils.copyProperties(todosRecordDTO, todosModel);
        TodosModel savedTodo = todosService.create(todosModel);
        savedTodo.add(linkTo(methodOn(TodosController.class).getOneTodo(savedTodo.getId())).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodosModel>> getAllTodos(){
        List<TodosModel> todosList = todosService.list();
        if(!todosList.isEmpty()) {
            for(TodosModel todos : todosList) {
                todos.add(linkTo(methodOn(TodosController.class).getOneTodo(todos.getId())).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(todosList);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Object> getOneTodo(@PathVariable(value="id") UUID id){
        Optional<TodosModel> todos = todosService.listId(id);
        if(todos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
        }
        todos.get().add(linkTo(methodOn(TodosController.class).getAllTodos()).withRel("To Do List"));
        return ResponseEntity.status(HttpStatus.OK).body(todos.get());
    }


    @PutMapping("/todos/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid TodosRecordDTO todosRecordDTO) {
        Optional<TodosModel> todoOptional = todosService.listId(id);
        if (todoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
        }
        var todosModel = todoOptional.get();
        BeanUtils.copyProperties(todosRecordDTO, todosModel);
        TodosModel updatedTodo = todosService.update(todosModel);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTodo);
    }


    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable(value="id") UUID id) {
        List<TodosModel> todo = todosService.delete(id);
        if(todo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
        }
        this.todosService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully.");
    }
}
