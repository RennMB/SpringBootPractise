package com.example.demo.Service;

import com.example.demo.model.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);
    List<Task> getAll();
    Task update(Task task);
    void delete(Integer id);
    //extra operations
    List<Task> getNewest();
}
