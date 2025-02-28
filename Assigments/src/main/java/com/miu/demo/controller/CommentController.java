package com.miu.demo.controller;

import com.miu.demo.domain.Comment;
import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;
import com.miu.demo.repository.CommentRepo;
import com.miu.demo.repository.UserRepo;
import com.miu.demo.service.CommentService;
import com.miu.demo.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {
    private CommentService commentService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping // GET - localhost:8080/api/users
    public List<Comment> getAll() {
        return commentService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Comment> getById(@PathVariable("id") int id) {
        return commentService.findById(id);
    }


    @PostMapping("/{postId}")
    public Comment addComment(@PathVariable int postId, @RequestBody Comment comment) {
        return commentService.saved(postId, comment);
    }
}
