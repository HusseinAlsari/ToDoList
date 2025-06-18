package org.example.todolist.controller;

import jakarta.transaction.Transactional;
import org.example.todolist.model.Todo;
import org.example.todolist.repo.TodoRepo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {

    private final TodoRepo todoRepo;

    public TodoController(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    /// TODOList MAPPINGS
    /// create a new list
    @PostMapping("/todo/add")
    public void addTodo(@RequestBody Todo todo) {
        todoRepo.save(todo);
    }

    // shows all TodosList
    @GetMapping("/todo")
    public List<Todo> findAllTodo() {
        return todoRepo.findAll();
    }

    // delete TodoList by name
    @Transactional
    @DeleteMapping("/todo/delete/{name}")
    public void deleteTodo(@PathVariable String name) {
        todoRepo.deleteTodoByName(name);
    }
}
