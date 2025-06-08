package com.lions_internationals.dto.publicResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponse {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String memberNumber;
    private String address;
    private String category;
    private String position;
    private String image;
}
