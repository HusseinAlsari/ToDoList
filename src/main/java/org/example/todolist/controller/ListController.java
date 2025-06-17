package org.example.todolist.controller;

import org.example.todolist.model.Task;
import org.example.todolist.model.Todo;
import org.example.todolist.model.User;
import org.example.todolist.repo.TaskRepo;
import org.example.todolist.repo.TodoRepo;
import org.example.todolist.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @GetMapping("/")
//    public String listPage(){
//        return "listPage";
//    }

//    @PostMapping("/task")
//    public Task createList(@RequestBody Task todo) {
//        // Save the list to the database
//        return todo;
//    }
    //user controllers
    //add user
    @PostMapping("/user/add")
    public void addUser(@RequestBody User user){
        userRepo.save(user);
    }

    @GetMapping("/user")
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }
    //get user
//    @GetMapping("/user/{username}")
//    public ResponseEntity<User> getUser(@PathVariable("uName") String uName){
//        return userRepo.fin
//        (uName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }




    @PostMapping("/todo/add")
    public void addTodo(@RequestBody Todo todo){
        todoRepo.save(todo);
    }
    @GetMapping("/todo")
    public List<Todo> findAllTodo(){
        return todoRepo.findAll();
    }



    @PostMapping("/task/add")
    public void addTask(@RequestBody Task task){
        taskRepo.save(task);
    }

    @GetMapping("/task")
    public List<Task> findAllTask(){
        return taskRepo.findAll();
    }
}
