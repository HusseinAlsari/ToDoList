//package org.example.todolist.controller;
//
//import jakarta.transaction.Transactional;
//import org.example.todolist.model.Task;
//import org.example.todolist.model.Todo;
//import org.example.todolist.model.User;
//import org.example.todolist.repo.TaskRepo;
//import org.example.todolist.repo.TodoRepo;
//import org.example.todolist.repo.UserRepo;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class ListController {
//
//    private final UserRepo userRepo;
//    private final TaskRepo taskRepo;
//    private final TodoRepo todoRepo;
//
//    public ListController(UserRepo userRepo, TaskRepo taskRepo, TodoRepo todoRepo) {
//        this.userRepo = userRepo;
//        this.taskRepo = taskRepo;
//        this.todoRepo = todoRepo;
//    }
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///// USER MAPPINGS
//    //user controllers
//    //add user
//    @PostMapping("/user/add")
//    public void addUser(@RequestBody User user){
//        userRepo.save(user);
//    }
//
//    @GetMapping("/user")
//    public List<User> findAllUsers(){
//        return userRepo.findAll();
//    }
//
//    //delete user by name
//    @Transactional
//    @DeleteMapping("/user/delete/{username}")
//    public void deleteUser(@PathVariable String username){
//        userRepo.deleteUserByUsername(username);
//    }
//
//    //@PutMapping
//    //get a user by name
////    @GetMapping("/user/{username}")
////    public ResponseEntity<User> getUser(@PathVariable("uName") String uName){
////        return userRepo.fin
////        (uName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
////    }
//
//
//
///// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///// TODOList MAPPINGS
///// create a new list
//    @PostMapping("/todo/add")
//    public void addTodo(@RequestBody Todo todo){
//        todoRepo.save(todo);
//    }
//    // shows all TodosList
//    @GetMapping("/todo")
//    public List<Todo> findAllTodo(){
//        return todoRepo.findAll();
//    }
//
//    // delete TodoList by name
//    @Transactional
//    @DeleteMapping("/todo/delete/{name}")
//    public void deleteTodo(@PathVariable String name){
//        todoRepo.deleteTodoByName(name);
//    }
//
//
//
//    /// ///////////////////////////////////////////////////////////////////////////////////////
//    /// TASK MAPPINGS
//    //send a new task
//    @PostMapping("/task/add")
//    public void addTask(@RequestBody Task task){
//        taskRepo.save(task);
//    }
//
//    //display all tasks
//    @GetMapping("/task")
//    public List<Task> findAllTask(){
//        return taskRepo.findAll();
//    }
//
//    //delete task by title
//    @Transactional
//    @DeleteMapping("/task/delete/{title}")
//    public void deleteTask(@PathVariable String title){
//    taskRepo.deleteTaskByTitle(title);
//    }
//    //update a task
//    @PutMapping("/task/update/{tid}")
//    public ResponseEntity<Task> updateTask(@PathVariable int tid, @RequestBody Task task){
//        return taskRepo.findById(tid).map(oldTask ->{
//            oldTask.setTitle(task.getTitle());
//            oldTask.setDescription(task.getDescription());
//            oldTask.setPriority(task.getPriority());
//            return ResponseEntity.ok(taskRepo.save(oldTask));
//        })
//                .orElse(ResponseEntity.notFound().build());
//    }
//}
