package com.miu.demo.controller;

import com.miu.demo.domain.Comment;
import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;
import com.miu.demo.repository.CommentRepo;
import com.miu.demo.repository.PostRepo;
import com.miu.demo.repository.UserRepo;
import com.miu.demo.service.CommentService;
import com.miu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {
    private final PostRepo postRepo;
    private CommentService commentService;
    @Autowired
    CommentController(CommentService commentService, PostRepo postRepo) {
        this.commentService = commentService;
        this.postRepo = postRepo;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping // GET - localhost:8080/api/users
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentService.findAll());
    }


    @GetMapping("/{id}")
    public Optional<Comment> getById(@PathVariable("id") int id) {
        return commentService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateById(@PathVariable("id") int id, @RequestBody Comment comment) {
        Optional<Comment> optional = commentService.findById(id);
        if (optional.isPresent()) {
            Comment newComment = optional.get();
            newComment.setName(comment.getName());
            commentService.saved(newComment);
            return ResponseEntity.ok(newComment);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity<Comment> addComment( @RequestBody Map<String, Object> payload) {
        int postId = ((Number) payload.get("post_id")).intValue();
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment();
        comment.setName((String) payload.get("name"));

        commentService.saved(comment);
        post.getComments().add(comment);
        postRepo.save(post);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/id")

    public void deleteById(@PathVariable("id") int id) {
        commentService.delete(id);
    }
}
