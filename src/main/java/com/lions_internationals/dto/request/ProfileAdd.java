package com.lions_internationals.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProfileAdd {
    @NotBlank(message = "Full name is required.")
    private String fullName;

    @Email(message = "Email should be valid.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Phone number is required.")
    private String phoneNumber;

    @NotBlank(message = "Member number is required.")
    private String memberNumber;

    @NotBlank(message = "Address is required.")
    private String address;

    @NotBlank(message = "Category is required.")
    private String category;

    @NotBlank(message = "Position is required.")
    private String position;

    @NotNull(message = "Priority is required.")
    private Integer priority;

    @NotNull(message = "Image must not be null")
    private MultipartFile image;
}
