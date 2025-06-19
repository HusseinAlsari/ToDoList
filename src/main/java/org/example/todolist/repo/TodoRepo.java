package org.example.todolist.repo;

import org.example.todolist.model.Task;
import org.example.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TodoRepo extends JpaRepository<Todo, Integer> {
    List<Task> findByTodoId(int id);
    Todo findById(int id);
    void deleteTodoByName(String name);

}
