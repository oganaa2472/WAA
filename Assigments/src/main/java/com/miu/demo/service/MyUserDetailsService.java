package com.miu.demo.service;


import com.miu.demo.domain.MyUserDetails;
import com.miu.demo.domain.User;
import com.miu.demo.repository.UserRepo;
import jakarta.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;
    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return new MyUserDetails(user);
    }
}