package org.example.todolist.controller;

import jakarta.transaction.Transactional;
import org.example.todolist.model.User;
import org.example.todolist.repo.UserRepo;
import org.example.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// USER MAPPINGS
    //user controllers
    //add user
    @PostMapping("/")
    public void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    //delete user by name
    @Transactional
    @DeleteMapping("/delete/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUserByUsername(username);
    }

    //@PutMapping
    //get a user by name
//    @GetMapping("/user/{username}")
//    public ResponseEntity<User> getUser(@PathVariable("uName") String uName){
//        return userRepo.fin
//        (uName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }

}
