package com.miu.demo.repository;

import com.miu.demo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
//    public List<Post> findAll();

    @Query("select p from Post p where p.name=:title")
    List<Post> searchByTitle(@Param("title") String title);
//    public List<Post> getPostsByAuthor(String author);
//    public List<Post> searchPostsByAuthor(String text);
//List<Post> findByTitleContaining(String title);

}