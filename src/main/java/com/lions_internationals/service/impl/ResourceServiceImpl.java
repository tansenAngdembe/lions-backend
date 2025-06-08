package com.lions_internationals.service.impl;

import com.lions_internationals.dto.request.ResourceRequest;
import com.lions_internationals.dto.request.ResourceRequestDto;
import com.lions_internationals.dto.response.ResourceResponse;
import com.lions_internationals.entitiy.Resources;
import com.lions_internationals.mapper.ResourceMapper;
import com.lions_internationals.repository.ResourceRepository;
import com.lions_internationals.service.ResourceService;
import com.lions_internationals.util.ResponseUtil;
import com.lions_internationals.util.api.ApiResponse;
import com.lions_internationals.util.service.FileService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    private final FileService fileService;
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    public ResourceServiceImpl(FileService fileService, ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.fileService = fileService;
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Transactional
    @Override
    public ApiResponse<?> addResource(ResourceRequest request) {
        String filePath = fileService.uploadFile(request.getFile());
        Resources resources = new Resources();
        resources.setName(request.getName());
        resources.setCategory(request.getCategory());
        resources.setFilePath(filePath);
        resources.setCreatedAt(new Date());
        resources.setUpdatedAt(new Date());
        resourceRepository.save(resources);
        System.out.println(filePath);
        return ResponseUtil.getSuccessfulServerResponse("Resource added successfully.", 201);
    }

    @Override
    public ApiResponse<?> getAll() {
        List<Resources> all = resourceRepository.findAll();
        List<ResourceResponse> allResponse = resourceMapper.getAllResponse(all);
        if (allResponse.isEmpty()) {
            return ResponseUtil.getFailureResponse("Failed to fetched resources, or Empty list of resources.");
        }
        return ResponseUtil.getSuccessfulServerResponse(allResponse, "Resources fetched successfully.", 200);

    }

    @Override
    public ApiResponse<?> deleteResources(ResourceRequestDto request) {
        boolean idExists = resourceRepository.existsById(request.getId());
        if (idExists) {
            resourceRepository.deleteById(request.getId());
            return ResponseUtil.getSuccessfulServerResponse("Resource deleted successfully.", 203);
        }
        return ResponseUtil.getFailureResponse("Failed to delete resource, resource not found.");
    }
}
