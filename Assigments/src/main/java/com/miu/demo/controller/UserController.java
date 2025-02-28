package com.miu.demo.controller;

import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;
import com.miu.demo.domain.dto.PostDto;
import com.miu.demo.service.PostService;
import com.miu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping // POST - /api/users
    public void save(@RequestBody User user) { // Json --> Java
        userService.saveUser(user);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping // GET - localhost:8080/api/users
    public List<User> getAll() {
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") int id) {
        return userService.getById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable int id) {
        return userService.getUserPosts(id);
    }

//
//    @DeleteMapping("/id")
//    public Optional<User> delete(@PathVariable("id") int id) {
//        return userService.deleteUser(id);
//    }
}
