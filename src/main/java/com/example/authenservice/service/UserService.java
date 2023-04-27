package com.example.authenservice.service;

import com.example.authenservice.entity.User;
import com.example.authenservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public User getUserById(String id){
        return repository.findById(id).isPresent()?repository.findById(id).get(): null;
    }
    public User loadUserByUsername(String username){
        return repository.findByUsername(username).isPresent()?repository.findByUsername(username).get(): null;
    }
}
