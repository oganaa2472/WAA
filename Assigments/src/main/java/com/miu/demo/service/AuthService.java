package com.miu.demo.service;


import com.miu.demo.domain.request.LoginRequest;
import com.miu.demo.domain.request.RefreshTokenRequest;
import com.miu.demo.domain.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}