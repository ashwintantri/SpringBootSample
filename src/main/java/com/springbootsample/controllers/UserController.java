package com.springbootsample.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsample.model.User;
import com.springbootsample.repositories.UserRepository;

@RestController
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<User>> index() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    
 }
