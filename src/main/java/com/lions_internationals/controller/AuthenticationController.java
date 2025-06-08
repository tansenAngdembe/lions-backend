package com.lions_internationals.controller;

import com.lions_internationals.dto.request.Login;
import com.lions_internationals.service.AuthenticationService;
import com.lions_internationals.util.api.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ApiResponse<?> authentication(@RequestBody Login request, HttpServletResponse response) {
        return authenticationService.authentication(request, response);
    }

    @PostMapping("/logout")
    public ApiResponse<?> logout(HttpServletResponse response){
        return authenticationService.logout(response);
    }
}
