package com.lions_internationals.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ResourceRequest {
    private String name;
    private String category;
    private MultipartFile file;
}
