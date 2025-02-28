package com.miu.demo.service.impl;

import com.miu.demo.domain.Comment;
import com.miu.demo.domain.Post;
import com.miu.demo.repository.CommentRepo;
import com.miu.demo.repository.PostRepo;
import com.miu.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;
    private  PostRepo postRepo;

    public CommentServiceImpl(CommentRepo commentRepository, PostRepo postRepository) {
        this.commentRepo = commentRepository;
        this.postRepo = postRepository;
    }

    @Override
    public Comment saved(int postId,Comment comment) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        post.getComments().add(comment);
        postRepo.save(post);
        return comment;
    }
    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }
    @Override
    public Optional<Comment> findById(int id) {
        return commentRepo.findById(id);
    }
}
