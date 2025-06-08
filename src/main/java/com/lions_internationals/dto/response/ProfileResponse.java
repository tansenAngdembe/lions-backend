package com.lions_internationals.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ProfileResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String memberNumber;
    private String address;
    private String category;
    private String position;
    private Integer priority;
    private String image;
    private Date createdAt;
    private Date updatedAt;
}
