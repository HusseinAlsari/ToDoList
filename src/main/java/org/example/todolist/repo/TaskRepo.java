package org.example.todolist.repo;

import org.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskRepo extends JpaRepository<Task, Integer> {
    public Task findById(int tid);
    void deleteTaskByTitle(String title);
}
