package org.example.todolist.controller;

import jakarta.transaction.Transactional;
import org.example.todolist.model.User;
import org.example.todolist.repo.UserRepo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
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

    //@PutMapping
    //get a user by name
//    @GetMapping("/user/{username}")
//    public ResponseEntity<User> getUser(@PathVariable("uName") String uName){
//        return userRepo.fin
//        (uName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }

}
