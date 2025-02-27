package com.miu.demo.service;

import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;


import java.util.List;

public interface UserService {
    public List<User> findAll();
    User getById(int id);
    void save(User user);
    public List<Post> getUserPosts(int id);
}
