package org.example.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Task")
public class Task {
    @Id
   private int tId;
   private String tName;
   private String tDescription;
   private String tPriority;

    public Task(int tId, String tName, String tDescription, String tPriority) {
        this.tId = tId;
        this.tName = tName;
        this.tDescription = tDescription;
        this.tPriority = tPriority;
    }

    public Task() {

    }

    public int gettId() {
        return tId;
    }

    public String gettName() {
        return tName;
    }

    public String gettDescription() {
        return tDescription;
    }

    public String gettPriority() {
        return tPriority;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public void settDescription(String tDescription) {
        this.tDescription = tDescription;
    }

    public void settPriority(String tPriority) {
        this.tPriority = tPriority;
    }
}
