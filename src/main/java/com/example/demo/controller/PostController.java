package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")

public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/getPosts")
    public List<Post>getPosts(){
        return postService.getAll();
    }

    @PostMapping("/create")
    public Post create(@RequestBody Post post){
        return postService.create(post);
    }

    @PostMapping("/update")
    public Post update(@RequestBody Post post){
        return postService.update(post);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        postService.delete (id);
        return "Already deleted";
    }
}
