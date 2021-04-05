package com.example.demo.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll().stream().map(x -> {
            x.setTimeCreated("GMT (+6) " + x.getTimeCreated());
            return x;
        }
        ).collect(Collectors.toList());
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getNewest(){
        List<Task> oldList = taskRepository.findAll();
        List<Task> newList = new ArrayList<>();
        for(int i = oldList.size()-1; i >= 0; i--){
            newList.add(oldList.get(i));
        }

        newList.stream().map(x -> {
                    x.setTimeCreated("GMT (+6) " + x.getTimeCreated());
                    return x;
                }
        ).collect(Collectors.toList());

        return newList;
    }
}
