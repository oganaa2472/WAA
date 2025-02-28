package com.miu.demo.service;

import com.miu.demo.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    public Comment saved(int postId,Comment comment);
    public List<Comment> findAll() ;
    public Optional<Comment> findById(int id);

}
