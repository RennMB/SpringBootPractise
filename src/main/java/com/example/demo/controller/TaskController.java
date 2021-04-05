package com.example.demo.controller;


import com.example.demo.Service.TaskService;
import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;
// read
    @GetMapping("/getTasks")
    public List<Task>getTasks() {
        return taskService.getAll();
    }
// create
    @PostMapping("/create")
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }
// update
    @PostMapping("/update")
    public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }
// delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        taskService.delete(id);
        return "Already deleted";
    }
    @GetMapping("/getNewest")
    public List<Task> getNewest(){
        return taskService.getNewest();
    }
}
