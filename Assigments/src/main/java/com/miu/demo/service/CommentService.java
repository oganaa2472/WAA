package com.miu.demo.service;

import com.miu.demo.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    public void saved(Comment comment);
    public List<Comment> findAll() ;
    public Optional<Comment> findById(int id);
    public void delete(int id);


}
