package org.example.todolist.controller;

import jakarta.transaction.Transactional;
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// USER MAPPINGS
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

    //delete user by name
    @Transactional
    @DeleteMapping("/user/delete/{username}")
    public void deleteUser(@PathVariable String username){
        userRepo.deleteUserByUsername(username);
    }
    //get a user by name
//    @GetMapping("/user/{username}")
//    public ResponseEntity<User> getUser(@PathVariable("uName") String uName){
//        return userRepo.fin
//        (uName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }



/// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// TODOList MAPPINGS
/// create a new list
    @PostMapping("/todo/add")
    public void addTodo(@RequestBody Todo todo){
        todoRepo.save(todo);
    }
    // shows all TodosList
    @GetMapping("/todo")
    public List<Todo> findAllTodo(){
        return todoRepo.findAll();
    }

    // delete TodoList by name
    @Transactional
    @DeleteMapping("/todo/delete/{name}")
    public void deleteTodo(@PathVariable String name){
        todoRepo.deleteTodoByName(name);
    }



    /// ///////////////////////////////////////////////////////////////////////////////////////
    /// TASK MAPPINGS
    //send a new task
    @PostMapping("/task/add")
    public void addTask(@RequestBody Task task){
        taskRepo.save(task);
    }

    //display all tasks
    @GetMapping("/task")
    public List<Task> findAllTask(){
        return taskRepo.findAll();
    }

    //delete task by title
    @Transactional
    @DeleteMapping("/task/delete/{title}")
    public void deleteTask(@PathVariable String title){
    taskRepo.deleteTaskByTitle(title);
    }
    //edit a task
//    @PutMapping("/task/update{tid}")
//    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable int tid){
//        Task task1 = taskRepo.update(id, updateItem);
//        return ResponseEntity.ok(task1);
//    }
}
