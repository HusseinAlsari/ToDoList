package org.example.todolist.model;

public class Todo {
    private String LName;
    private Task task;

    public Todo(String LName, Task task) {
        this.LName = LName;
        this.task = task;
    }

    public String getLName() {
        return LName;
    }


    public Task getTasks() {
        return task;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public void setTasks(Task task) {
        this.task = task;
    }
}
