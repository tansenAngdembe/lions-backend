package com.lions_internationals.controller;

import com.lions_internationals.dto.ProfileUpdateDto;
import com.lions_internationals.dto.request.ProfileRequest;
import com.lions_internationals.dto.request.ProfileAdd;
import com.lions_internationals.service.ProfileService;
import com.lions_internationals.util.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private final ProfileService profileService;


    @PostMapping("/add")
    public ApiResponse<?> addProfiles(@ModelAttribute @Validated ProfileAdd request){
        return profileService.addProfile(request);
    }

    // Get all profiles
    @PostMapping("/getAll")
    public ApiResponse<?> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    //Get profile by id
    @PostMapping("/get")
    public ApiResponse<?> getProfile(@RequestBody ProfileRequest request) {
        return profileService.getProfilesById(request);
    }

    //Delete profile (change-flag)
    @PostMapping("/delete")
    public ApiResponse<?> deleteProfile(@RequestBody ProfileRequest request) {
        return profileService.deleteProfile(request);
    }

    //Update Profile
    @PostMapping("/update")
    public ApiResponse<?> updateProfile(@ModelAttribute ProfileUpdateDto request) {
        return profileService.updateProfile(request);
    }

}
