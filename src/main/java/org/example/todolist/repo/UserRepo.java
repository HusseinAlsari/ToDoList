package org.example.todolist.repo;

import org.example.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer> {
    User findUsersByUsername(String username);
    boolean existsByUsername(String username);
    User findByUsername(String username);
    public void deleteUserByUsername(String username);
}
