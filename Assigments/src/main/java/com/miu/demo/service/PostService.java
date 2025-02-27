package com.miu.demo.service;


import com.miu.demo.domain.Post;
import com.miu.demo.domain.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> findAll();
    Optional<Post> getById(int id);
    void savePost(Post post);
//    void delete(int id);
//    void update(int id, PostDto postDto);
//    public List<PostDto> getPostsByAuthor(String author);
//    public List<PostDto> searchPostsByAuthor(String text);
}