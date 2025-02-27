package com.miu.demo.service;

import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();
    Optional<User> getById(int id);
    void saveUser(User user);
    public List<Post> getUserPosts(int id);
}
