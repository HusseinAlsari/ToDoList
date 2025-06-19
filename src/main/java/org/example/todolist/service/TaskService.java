package org.example.todolist.service;

import org.example.todolist.dto.TaskReqDto;
import org.example.todolist.model.Task;
import org.example.todolist.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepo taskRepo;
    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }
    public List<Task> findAll() {
        return taskRepo.findAll();
    }
    public Optional<Task> findById(Integer id) {
        return taskRepo.findById(id);
    }
    public Task save(Task task) {
        return taskRepo.save(task);
    }
    public void deleteByName(String name) {
        taskRepo.deleteTaskByTitle(name);
    }
    public TaskReqDto getById(int id){
        Task taskEntity = taskRepo.findById(id).get();
       return TaskReqDto.builder().title(taskEntity.getTitle()).
               description(taskEntity.getDescription()).
               priority(taskEntity.getPriority()).build();
    }
    public TaskReqDto getByTitle(String title){
        Task taskEntity = taskRepo.findByTitle(title);
        return TaskReqDto.builder().title(taskEntity.getTitle()).
                description(taskEntity.getDescription()).
                priority(taskEntity.getPriority()).build();
    }

    public void deleteTaskByTitle(String title) {
        taskRepo.deleteTaskByTitle(title);
    }
}
