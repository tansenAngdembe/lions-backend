package com.lions_internationals.controller;

import com.lions_internationals.dto.request.ResourceRequest;
import com.lions_internationals.dto.request.ResourceRequestDto;
import com.lions_internationals.service.ResourceService;
import com.lions_internationals.util.api.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/resources")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping("/add")
    public ApiResponse<?> addResource(@ModelAttribute ResourceRequest request) {
        return resourceService.addResource(request);
    }

    @PostMapping("/get-all")
    public ApiResponse<?> getAll() {
        return resourceService.getAll();
    }

    @PostMapping("/delete")
    public ApiResponse<?> deleteResources(@RequestBody ResourceRequestDto request) {
        return resourceService.deleteResources(request);
    }
}
