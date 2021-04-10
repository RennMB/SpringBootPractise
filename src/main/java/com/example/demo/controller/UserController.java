package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public List<User>getUsers(){
        return userService.getAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "Already deleted";
    }

}
