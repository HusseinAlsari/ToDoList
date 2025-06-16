package org.example.todolist.controller;

import org.example.todolist.model.Task;
import org.example.todolist.model.Todo;
import org.example.todolist.model.User;
import org.example.todolist.repo.TaskRepo;
import org.example.todolist.repo.TodoRepo;
import org.example.todolist.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListController {

    private final UserRepo userRepo;
    private final TaskRepo taskRepo;
    private final TodoRepo todoRepo;

    public ListController(UserRepo userRepo, TaskRepo taskRepo, TodoRepo todoRepo) {
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
        this.todoRepo = todoRepo;
    }

    @GetMapping("/")
    public String listPage(){
        return "listPage";
    }

//    @PostMapping("/task")
//    public Task createList(@RequestBody Task todo) {
//        // Save the list to the database
//        return todo;
//    }
    //user controllers
    //add user
    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userRepo.save(user);
    }
    //get user
//    @GetMapping("/user/{username}")
//    public ResponseEntity<User> getUser(@PathVariable("uName") String uName){
//        return userRepo.fin
//        (uName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }




    @PostMapping("/addtodo")
    public void addTodo(@RequestBody Todo todo){
        todoRepo.save(todo);
    }
    @PostMapping("/addtask")
    public void addTask(@RequestBody Task task){
        taskRepo.save(task);
    }

}
