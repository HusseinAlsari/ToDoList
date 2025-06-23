package org.example.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int tid;
   private String title;
   private String description;
   private String priority;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = true)
    private Todo todo;

    public Task() {

    }
}
