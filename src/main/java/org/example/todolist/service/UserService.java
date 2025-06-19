package org.example.todolist.service;

import org.example.todolist.dto.UserReqDto;
import org.example.todolist.model.User;
import org.example.todolist.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserReqDto getUserByUsername(String username){
        User userEntity = userRepo.findByUsername(username);
        return UserReqDto.builder().
                username(userEntity.getUsername()).
                password(userEntity.getPassword()).
                build();
    }
    public void deleteUserByUsername(String username){
        userRepo.deleteUserByUsername(username);
    }
    public void saveUser(User user){
        userRepo.save(user);
    }
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }
}
