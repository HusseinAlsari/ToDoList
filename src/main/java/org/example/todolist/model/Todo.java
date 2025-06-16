package org.example.todolist.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL,orphanRemoval = true) //many tasks to one todo
    private List<Task> tasks;

    public Todo() {

    }
}
