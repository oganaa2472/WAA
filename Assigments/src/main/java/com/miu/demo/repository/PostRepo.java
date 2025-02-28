package com.miu.demo.repository;

import com.miu.demo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
//    public List<Post> findAll();
//    public List<Post> getPostsByAuthor(String author);
//    public List<Post> searchPostsByAuthor(String text);
//    public Post getById(int id);
List<Post> findByTitleContaining(String title);
//    public void save(Post p);
//
//    public void delete(int id);
//
//    public void update(int id, Post p);

}