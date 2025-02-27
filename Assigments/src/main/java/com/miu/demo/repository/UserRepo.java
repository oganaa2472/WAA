package com.miu.demo.repository;

import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
