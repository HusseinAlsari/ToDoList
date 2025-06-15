package org.example.todolist.controller;

import org.example.todolist.model.Task;
import org.example.todolist.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @GetMapping("/")
    public String listPage(){
        return "listPage";
    }

    @PostMapping("/task")
    public Task createList(@RequestBody Task todo) {
        // Save the list to the database
        return todo;
    }
}
