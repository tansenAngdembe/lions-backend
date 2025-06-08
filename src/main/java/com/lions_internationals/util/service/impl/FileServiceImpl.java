package com.lions_internationals.util.service.impl;

import com.lions_internationals.util.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    // Base directories to store files
    private final String UPLOAD_PDF_DIR = "uploads/resources/";
    private final String UPLOAD_IMAGE_DIR = "uploads/profiles/";

    // Allowed image types
    private final List<String> ALLOWED_IMAGE_TYPES = List.of("image/png", "image/jpeg", "image/jpg","image/svg");

    @Override
    public String uploadFile(MultipartFile file) {
        // Validate file type
        if (!file.getContentType().equals("application/pdf")) {
            throw new IllegalArgumentException("Only PDF files are allowed.");
        }

        // Save the file to the specified directory
        return saveFile(file, UPLOAD_PDF_DIR);
    }

    @Override
    public String uploadImage(MultipartFile image) {
        // Validate image type
        if (!ALLOWED_IMAGE_TYPES.contains(image.getContentType())) {
            throw new IllegalArgumentException("Only PNG, JPEG, and JPG images are allowed.");
        }

        // Save the image to the specified directory
        return saveFile(image, UPLOAD_IMAGE_DIR);
    }

    // Reusable method for saving files
    private String saveFile(MultipartFile file, String directoryPath) {
        // Create the directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Generate a unique filename
        String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(directoryPath, uniqueFileName);

        // Write the file to the path
        try {
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error saving file: " + filePath, e);
        }

        // Return the relative path with forward slashes for URL compatibility
        return filePath.toString().replace("\\", "/");
    }
}
