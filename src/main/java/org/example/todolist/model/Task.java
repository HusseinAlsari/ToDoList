package org.example.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Task")
public class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int tId;
   private String tName;
   private String tDescription;
   private String tPriority;
    @ManyToOne
    @JoinColumn(name = "Todo_id")
    private Todo todo;

    public Task() {

    }
}
