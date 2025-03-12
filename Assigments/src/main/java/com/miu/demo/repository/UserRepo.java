package com.miu.demo.repository;

import com.miu.demo.domain.Post;
import com.miu.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE SIZE(u.postList) > :n")
    List<User> findUsersWithMoreThanNPosts(@Param("n") int n);

    User findByEmail(String email);
}
