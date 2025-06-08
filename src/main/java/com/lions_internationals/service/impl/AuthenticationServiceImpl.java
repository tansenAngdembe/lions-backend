package com.lions_internationals.service.impl;

import com.lions_internationals.core.service.JwtService;
import com.lions_internationals.dto.request.Login;
import com.lions_internationals.service.AuthenticationService;
import com.lions_internationals.util.ResponseUtil;
import com.lions_internationals.util.api.ApiResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public ApiResponse<?> authentication(Login request, HttpServletResponse response) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            String token = jwtService.generateToken(request.getEmail());
            Cookie cookie = new Cookie("jwt", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
            return ResponseUtil.getSuccessfulServerResponse("Logged in successful");
        }catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            return ResponseUtil.getFailureResponse("Invalid credentials, login failed.");
        }
    }

    @Override
    public ApiResponse<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseUtil.getSuccessfulServerResponse("Logout successful");
    }
}
