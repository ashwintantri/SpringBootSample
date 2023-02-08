package com.springbootsample.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsample.model.User;
import com.springbootsample.repositories.UserRepository;

@RestController
@Transactional
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<User>> index() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/fillDummyData")
    public ResponseEntity<String> fillDummyData() {
        userRepository.save(new User("First","Second",false));
        userRepository.save(new User("Second","Third",false));
        userRepository.save(new User("Fourth","Fifth",false));
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>("Deleted"+id,HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
 }
