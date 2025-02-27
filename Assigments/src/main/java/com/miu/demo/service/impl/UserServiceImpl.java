package com.miu.demo.service.impl;

import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;
import com.miu.demo.repository.PostRepo;
import com.miu.demo.repository.UserRepo;
import com.miu.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public List<Post> getUserPosts(int id) {
            return userRepo.findById(id)
                    .map(User::getPostList)
                    .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
