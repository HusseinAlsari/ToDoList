package org.example.todolist.controller;

import jakarta.transaction.Transactional;
import org.example.todolist.model.Task;
import org.example.todolist.repo.TaskRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    private final TaskRepo taskRepo;

    public TaskController(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
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
    //update a task
    @PutMapping("/task/update/{tid}")
    public ResponseEntity<Task> updateTask(@PathVariable int tid, @RequestBody Task task){
        return taskRepo.findById(tid).map(oldTask ->{
                    oldTask.setTitle(task.getTitle());
                    oldTask.setDescription(task.getDescription());
                    oldTask.setPriority(task.getPriority());
                    return ResponseEntity.ok(taskRepo.save(oldTask));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
