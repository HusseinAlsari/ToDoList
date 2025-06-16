package org.example.todolist.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Todo")
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String LName;
    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL,orphanRemoval = true) //many tasks to one todo
    @JoinColumn(name = "task_tId")
    private List<Task> taska;

    public Todo() {

    }
}
