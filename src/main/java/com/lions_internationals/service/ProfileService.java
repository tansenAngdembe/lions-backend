package com.lions_internationals.service;

import com.lions_internationals.dto.ProfileUpdateDto;
import com.lions_internationals.dto.publicRequest.ProfileCategoryRequest;
import com.lions_internationals.dto.publicRequest.ProfilePositionRequest;
import com.lions_internationals.dto.request.ProfileRequest;
import com.lions_internationals.dto.request.ProfileAdd;
import com.lions_internationals.util.api.ApiResponse;

public interface ProfileService {
    ApiResponse<?> addProfile(ProfileAdd request);
    ApiResponse<?> getAllProfiles();
    ApiResponse<?> getProfilesById(ProfileRequest request);
    ApiResponse<?> deleteProfile(ProfileRequest request);
    ApiResponse<?> updateProfile(ProfileUpdateDto request);
    ApiResponse<?> getProfilesByCategory(ProfileCategoryRequest category);
    ApiResponse<?> getProfilesByPosition(ProfilePositionRequest positionRequest);

}
