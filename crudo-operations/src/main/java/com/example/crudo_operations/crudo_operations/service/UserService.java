package com.example.crudo_operations.crudo_operations.service;

import com.example.crudo_operations.crudo_operations.model.User;
import com.example.crudo_operations.crudo_operations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private  final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.update(id, updatedUser);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
