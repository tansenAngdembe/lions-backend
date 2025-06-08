package com.lions_internationals.util;

import com.lions_internationals.core.constant.ServerResponseCodeConstant;
import com.lions_internationals.util.api.ApiResponse;
import org.springframework.http.HttpStatus;

public class ResponseUtil {
    public static ApiResponse getFailureResponse(String message) {
        return ApiResponse.builder()
                .code(ServerResponseCodeConstant.FAILURE)
                .message(message)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public static ApiResponse getFailureResponse(String message, Object data) {
        return ApiResponse.builder()
                .code(ServerResponseCodeConstant.FAILURE)
                .message(message)
                .data(data)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public static ApiResponse getSuccessfulServerResponse(String message){
        return ApiResponse.builder()
                .code(ServerResponseCodeConstant.SUCCESS)
                .message(message)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public static ApiResponse getSuccessfulServerResponse(String message, Integer code){
        return ApiResponse.builder()
                .code(code)
                .message(message)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public static ApiResponse getSuccessfulServerResponse(Object data, String message, Integer code) {
        return ApiResponse.builder()
                .code(code)
                .message(message)
                .data(data)
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
