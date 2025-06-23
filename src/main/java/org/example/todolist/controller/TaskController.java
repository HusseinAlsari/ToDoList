package org.example.todolist.controller;

import jakarta.transaction.Transactional;
import org.example.todolist.dto.TaskReqDto;
import org.example.todolist.model.Task;
import org.example.todolist.model.Todo;
import org.example.todolist.service.TaskService;
import org.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
//    private final TaskRepo taskRepo;
//
//    public TaskController(TaskRepo taskRepo) {
//        this.taskRepo = taskRepo;
//    }
    private TaskService taskService;
    private TodoService todoService;

    @Autowired
    public TaskController(TaskService taskService, TodoService todoService) {
        this.taskService = taskService;
        this.todoService = todoService;
    }
    /// ///////////////////////////////////////////////////////////////////////////////////////
    /// TASK MAPPINGS
    //send a new task
    @PostMapping("/")
    public ResponseEntity<?> addTask(@RequestBody TaskReqDto taskReqDto){
        try {
            Task task = taskService.convertToEntity(taskReqDto);
            //if the task has a todo reference, ensure it exists
            if (task.getTodo() != null && task.getTodo().getId() > 0) {
                int todoId = task.getTodo().getId();
                //find the todo in the database
                Todo todo = todoService.findById(todoId);

                if (todo != null) {
                    task.setTodo(todo);
                } else {
                    return ResponseEntity.status(404).body("Todo with ID " + todoId + " not found");
                }
            }
            //save the task
            Task savedTask = taskService.save(task);
            return ResponseEntity.ok(savedTask);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving task: " + e.getMessage());
        }
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
