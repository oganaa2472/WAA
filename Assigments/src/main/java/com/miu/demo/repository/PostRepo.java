package com.miu.demo.repository;

import com.miu.demo.domain.Post;

import java.util.List;

public interface PostRepo {

    public List<Post> findAll();
    public List<Post> getPostsByAuthor(String author);
    public List<Post> searchPostsByAuthor(String text);
    public Post getById(int id);

    public void save(Post p);

    public void delete(int id);

    public void update(int id, Post p);

}