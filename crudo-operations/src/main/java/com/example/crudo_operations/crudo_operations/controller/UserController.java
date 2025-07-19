package com.example.crudo_operations.crudo_operations.controller;

import com.example.crudo_operations.crudo_operations.model.User;
import com.example.crudo_operations.crudo_operations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    private  final UserService userService;
    @Autowired

    public  UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")

    public User updateUser(@PathVariable Long id , @RequestBody User updatedUser){
        return userService.updateUser(id,updatedUser);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id ) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
