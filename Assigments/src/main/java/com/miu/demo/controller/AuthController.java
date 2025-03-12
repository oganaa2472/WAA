package com.miu.demo.controller;


import com.miu.demo.domain.request.LoginRequest;
import com.miu.demo.domain.request.RefreshTokenRequest;
import com.miu.demo.domain.response.LoginResponse;
import com.miu.demo.service.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return new ResponseEntity<>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

}