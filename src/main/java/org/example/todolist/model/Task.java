package org.example.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int tId;
   private String title;
   private String description;
   private String priority;
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Task() {

    }
}
