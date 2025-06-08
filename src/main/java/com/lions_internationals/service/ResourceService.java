package com.lions_internationals.service;

import com.lions_internationals.dto.request.ResourceRequest;
import com.lions_internationals.dto.request.ResourceRequestDto;
import com.lions_internationals.util.api.ApiResponse;

public interface ResourceService {
    ApiResponse<?> addResource(ResourceRequest request);
    ApiResponse<?> getAll();
    ApiResponse<?> deleteResources(ResourceRequestDto request);
}
