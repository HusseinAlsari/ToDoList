package org.example.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller {
    @GetMapping
    public String getList("/"){
        return "list";
    }
}
