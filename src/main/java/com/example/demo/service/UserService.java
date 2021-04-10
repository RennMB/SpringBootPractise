package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update (User user);
    List<User> getAll();
    User getById(Long id);
    void delete(Long id);
}
