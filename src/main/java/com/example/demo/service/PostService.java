package com.example.demo.service;

import com.example.demo.model.Post;

import java.util.List;

public interface PostService {
    Post create(Post post);
    Post update(Post post);
    List<Post> getAll();
    List<Post> getByUser(Long userId);
    void delete(Long id);
}
