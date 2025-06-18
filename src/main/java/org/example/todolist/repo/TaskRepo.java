package org.example.todolist.repo;

import org.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface TaskRepo extends JpaRepository<Task, Integer> {
    void deleteTaskByTitle(String title);
    Task findByTitle(String title);
    Optional<Task> findById(int id);
}
