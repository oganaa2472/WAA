package com.miu.demo.controller;

import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;
import com.miu.demo.domain.dto.PostDto;
import com.miu.demo.repository.UserRepo;
import com.miu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    private final PostService postService;
    private final UserRepo userRepo;

    @Autowired
    public PostController(PostService postService, UserRepo userRepo) {
        this.postService = postService;
        this.userRepo = userRepo;
    }
    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable("id") int id) {
        return postService.getById(id);
    }
    @PostMapping
    public void createPost(@RequestBody Map<String, Object> payload) {
        int userId = ((Number) payload.get("user_id")).intValue();
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setName((String) payload.get("name"));
        post.setContent((String) payload.get("content"));
        post.setAuthor((String) payload.get("author"));
        user.getPostList().add(post);
        postService.save(post);
        userRepo.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping // GET - localhost:8080/api/posts
    public List<Post> getAll() {
        return postService.findAll();
    }
//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable int id) {
//        postService.delete(id);
//    }
//    @ResponseStatus(HttpStatus.OK)
//    @PutMapping("/{id}")
//    public void update(@PathVariable("id") int productId, @RequestBody PostDto p) {
//        postService.update(productId, p);
//    }
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/by-author")
//    public List<PostDto> getPostsByAuthor(@RequestParam String author) {
////        return postService.getPostsByAuthor(author);
//        return null;
//    }
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/search-author")
//    public List<Post> searchPostsByAuthor(@RequestParam String text) {
//        return postService.searchPostsByAuthor(text);
//        return null;
//    }
    @GetMapping("/by-title/{title}")
    public List<Post> searchByTitle(@PathVariable String title) {
        return postService.searchByTitle(title);
    }
}