package org.example.todolist.controller;

import jakarta.transaction.Transactional;
import org.example.todolist.model.Todo;
import org.example.todolist.repo.TodoRepo;
import org.example.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

//    private final TodoRepo todoRepo;
//
//    public TodoController(TodoRepo todoRepo) {
//        this.todoRepo = todoRepo;
//    }
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /// TODOList MAPPINGS
    /// create a new list
    @PostMapping("/add")
    public void addTodo(@RequestBody Todo todo) {
        todoService.save(todo);
    }

    // shows all TodosList
    @GetMapping("/")
    public List<Todo> findAllTodo() {
        return todoService.findAll();
    }

    // delete TodoList by name
    @Transactional
    @DeleteMapping("/delete/{name}")
    public void deleteTodo(@PathVariable String name) {
        todoService.deleteTodoByName(name);
    }
}
