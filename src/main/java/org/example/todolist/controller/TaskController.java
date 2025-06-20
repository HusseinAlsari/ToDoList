package org.example.todolist.controller;

import jakarta.transaction.Transactional;
import org.example.todolist.model.Task;
import org.example.todolist.repo.TaskRepo;
import org.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
//    private final TaskRepo taskRepo;
//
//    public TaskController(TaskRepo taskRepo) {
//        this.taskRepo = taskRepo;
//    }
    private TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    /// ///////////////////////////////////////////////////////////////////////////////////////
    /// TASK MAPPINGS
    //send a new task
    @PostMapping("/")
    public void addTask(@RequestBody Task task){
        taskService.save(task);
    }

    //display all tasks
    @GetMapping("/")
    public List<Task> findAllTask(){
        return taskService.findAll();
    }

    //delete task by title
    @Transactional
    @DeleteMapping("/delete/{title}")
    public void deleteTask(@PathVariable String title){
        taskService.deleteTaskByTitle(title);
    }
    //update a task
    @PutMapping("/update/{tid}")
    public ResponseEntity<Task> updateTask(@PathVariable int tid, @RequestBody Task task){
        return taskService.findById(tid).map(oldTask ->{
                    oldTask.setTitle(task.getTitle());
                    oldTask.setDescription(task.getDescription());
                    oldTask.setPriority(task.getPriority());
                    return ResponseEntity.ok(taskService.save(oldTask));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
