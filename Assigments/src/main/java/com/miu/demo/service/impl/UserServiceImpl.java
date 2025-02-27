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

import java.util.Optional;
@Service

public class UserServiceImpl implements UserService {



        @Autowired
        private UserRepo userRepository;

        public List<User> findAll() {
            return userRepository.findAll();
        }

        public Optional<User> getById(int id) {
            return userRepository.findById(id);
        }

        public void saveUser(User user) {
            userRepository.save(user);
        }

        public List<Post> getUserPosts(int id) {
            return userRepository.findById(id).map(User::getPostList).orElse(null);
        }

}
