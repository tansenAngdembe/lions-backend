package com.lions_internationals.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
public class ClubDto {
    @NotBlank(message = "Club name is required")
    private String clubName; //
    @NotBlank(message = "Club ID is required")
    private String clubId; //
    @NotBlank(message = "Member is required")
    private Long member; //
    @NotBlank(message = "District multiple is required")
    private String districtMultiple;
    @NotBlank(message = "Chartered Data is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date charteredDate;
    @NotBlank(message = "ExtensionChairperson is required")
    private String extensionChairperson;
    @NotBlank(message = "Guiding Lion Person one is required")
    private String guidingLionOne;
    @NotBlank(message = "guiding Lion Person two is required")
    private String guidingLionTwo;

    private MultipartFile logoUrl;
}
