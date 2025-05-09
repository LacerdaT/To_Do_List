package br.com.todolist.Model;

import org.springframework.data.jpa.repository.Query;
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
    @NonNull
    private String name;

    @Column(name = "DESCRIPTION")
    @NonNull
    private String description;

    @Column(name = "PRIORITY")
    private PriorityRole priority;

    @Column(name = "COMPLETED")
    private boolean completed;

    public TodosModel(){

    }

    public TodosModel(UUID id, @NonNull String name, @NonNull String description, PriorityRole priority, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }

    public TodosModel(Link initialLink, UUID id, @NonNull String name, @NonNull String description, PriorityRole priority, boolean completed) {
        super(initialLink);
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }

    public TodosModel(Iterable<Link> initialLinks, UUID id, @NonNull String name, @NonNull String description, PriorityRole priority, boolean completed) {
        super(initialLinks);
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }

    public TodosModel(@NonNull String name, @NonNull String description, PriorityRole priority, boolean completed) {
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

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public PriorityRole getPriority() {
        return priority;
    }

    public void setPriority(PriorityRole priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}

