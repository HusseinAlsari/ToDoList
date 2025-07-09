package org.example.todolist.controller;

import org.example.todolist.model.User;
import org.example.todolist.repo.UserRepo;
import org.example.todolist.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    final
    AuthenticationManager authenticationManager;
    final
    UserRepo userRepo;
    final
    PasswordEncoder encoder;
    final
    JwtUtil jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserRepo userRepo, PasswordEncoder encoder, JwtUtil jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }
    @PostMapping("/signup")
    public String registerUser(@RequestBody User user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            return "Error: Username is already taken!";
        }
        //create a new user with an encoded password
        User newUser = new User(
                user.getUsername(),
                encoder.encode(user.getPassword()),
                user.getEmail()
        );
        userRepo.save(newUser);
        return "User registered successfully!";
    }
}
