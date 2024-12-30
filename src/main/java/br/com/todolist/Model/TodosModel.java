package br.com.todolist.Model;

import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.Link;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "TODOS")
public class TodosModel extends RepresentationModel<TodosModel> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "COMPLETED")
    private boolean completed;

    public TodosModel(){

    }

    public TodosModel(UUID id, String name, String description, int priority, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodosModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", completed=" + completed +
                '}';
    }


}

