package com.miu.demo.controller;

import com.miu.demo.domain.Post;
import com.miu.demo.domain.dto.PostDto;
import com.miu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping // POST - /api/posts
    public void save(@RequestBody Post p) { // Json --> Java
        postService.save(p);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping // GET - localhost:8080/api/posts
    public List<PostDto> getAll() {
        return postService.findAll();
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int productId, @RequestBody PostDto p) {
        postService.update(productId, p);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/by-author")
    public List<PostDto> getPostsByAuthor(@RequestParam String author) {
        return postService.getPostsByAuthor(author);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search-author")
    public List<PostDto> searchPostsByAuthor(@RequestParam String text) {
        return postService.searchPostsByAuthor(text);
    }
    @GetMapping("/{id}")
    public PostDto getById(@PathVariable("id") int id) {
        return postService.getById(id);
    }

}