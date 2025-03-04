package com.miu.demo.service;


import com.miu.demo.domain.Post;
import com.miu.demo.domain.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> searchByTitle(String title);
    public List<Post> findAll();
    Optional<Post> getById(int id);
    void save(Post post);
    void delete(int id);
//    void update(int id, Post post);
//    public List<Post> getPostsByAuthor(String author);
//    public List<Post> searchByTitle(String text);
}