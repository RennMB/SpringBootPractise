package com.example.demo.bootstrap;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverterInterface;

@Component
public class TaskBootStrap implements ApplicationRunner {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        try{
        Task task1 = new Task("6:00", "Get up", "Don't be lazy");
        Task task2 = new Task("6:30", "Run", "Be stronger than yesterday");
        Task task3 = new Task("7:30", "Breakfast", "Not too much");

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
    }
        catch(DataIntegrityViolationException ex){
            System.out.println("Data Error" + ex.getClass());
        }

        catch (Exception ex){
            System.out.println("Unexpected Error");
            System.out.println(ex.getStackTrace());
        }

        finally {
            System.out.println("MainBootStrap executed");
        }
    }
}
