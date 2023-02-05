package com.springbootsample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsample.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    List<User> findByPublished(boolean published);
    List<User> findByTitleContaining(String title);
}