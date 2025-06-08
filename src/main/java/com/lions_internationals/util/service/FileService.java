package com.lions_internationals.util.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String uploadFile(MultipartFile file);
    public String uploadImage(MultipartFile image);
}
