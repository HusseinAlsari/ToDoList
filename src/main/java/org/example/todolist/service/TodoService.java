package org.example.todolist.service;

import org.example.todolist.model.Todo;
import org.example.todolist.repo.TodoRepo;
import org.example.todolist.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepo todoRepo;

    public TodoService( TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }
    public Todo findById(int id) {
        return todoRepo.findById(id);
    }
    public void deleteTodoByName(String name){
        todoRepo.deleteTodoByName(name);
    }
     public Todo findTodoById(int id) {
        return todoRepo.findById(id);
    }

    public List<Todo> findAll() {
        return todoRepo.findAll();
    }

    public void save(Todo todo) {
        todoRepo.save(todo);
    }
}
