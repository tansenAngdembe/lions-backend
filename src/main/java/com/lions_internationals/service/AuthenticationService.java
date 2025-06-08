package com.lions_internationals.service;

import com.lions_internationals.dto.request.Login;
import com.lions_internationals.util.api.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    ApiResponse<?> authentication(Login request, HttpServletResponse response);
    ApiResponse<?> logout(HttpServletResponse response);
}
