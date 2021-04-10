package com.example.demo.bootStrap;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;


public class PostBootStrap implements ApplicationRunner {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        try{
            User user1 = new User("Groot", 15, "groot@marvel.com");
            User user2 = new User("Raketa", 28, "raketa@marvel.com");
            User user3 = new User("Lord", 35, "lord@marvel.com");
            User user4 = new User("Gomora", 30, "gomora@marvel.com");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);

            Post post1 = new Post("I'm Groot", "I'm Groot", user1);
            Post post2 = new Post("Lord, not King", "I'm Lord, not a King", user3);
            Post post3 = new Post("Kill everyone", "I will kill everybody who will say that I'm a cat", user2);
            Post post4 = new Post("I know Tanos", "I know Tanos, because I'm his daughter", user4);

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);
            postRepository.save(post4);
        }
        catch (DataIntegrityViolationException ex){
            System.out.println("Data error" + ex.getClass());
        }
        catch (Exception ex){
            System.out.println("Unexpected error");
            System.out.println(ex.getStackTrace());
        }
        finally {
            System.out.println("BootStrap executed");
        }
    }
}
