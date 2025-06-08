package com.lions_internationals.service.impl;

import com.lions_internationals.dto.ProfileUpdateDto;
import com.lions_internationals.dto.publicRequest.ProfileCategoryRequest;
import com.lions_internationals.dto.publicRequest.ProfilePositionRequest;
import com.lions_internationals.dto.publicResponse.ProfileResponse;
import com.lions_internationals.dto.request.ProfileRequest;
import com.lions_internationals.dto.request.ProfileAdd;
import com.lions_internationals.entitiy.Profiles;
import com.lions_internationals.mapper.ProfileMapper;
import com.lions_internationals.mapper.RequestToProfileMapper;
import com.lions_internationals.repository.ProfileRepository;
import com.lions_internationals.service.ProfileService;
import com.lions_internationals.util.ResponseUtil;
import com.lions_internationals.util.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    @Qualifier("requestToProfileMapper")
    private final RequestToProfileMapper requestToEntity;
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;


    @Override
    public ApiResponse<?> addProfile(ProfileAdd request) {
        Profiles profiles = requestToEntity.requestToEntity(request);
        profileRepository.save(profiles);
        return ResponseUtil.getSuccessfulServerResponse("Profile Added Successfully", 201);
    }

    @Override
    public ApiResponse<?> getAllProfiles() {
        List<Profiles> all = profileRepository.findByIsDeletedFalse();
        if (all.isEmpty()){
            return ResponseUtil.getFailureResponse("Failed to fetch profiles");
        }
        List<com.lions_internationals.dto.response.ProfileResponse> allResponse = profileMapper.getAllResponse(all);
        return ResponseUtil.getSuccessfulServerResponse(allResponse, "Profiles fetched successfully", 200);
    }

    @Override
    public ApiResponse<?> getProfilesById(ProfileRequest request) {
        Profiles profiles = profileRepository.findById(request.getId()).orElseThrow(
                () -> new UsernameNotFoundException("Profile not found.")
        );
        if (profiles == null) {
            return ResponseUtil.getFailureResponse("Profile not found.");
        }
        com.lions_internationals.dto.response.ProfileResponse profileResponse = profileMapper.mapEntityToResponse(profiles);
        return ResponseUtil.getSuccessfulServerResponse(profileResponse, "Profile fetched successfully", 200);
    }

    @Override
    public ApiResponse<?> deleteProfile(ProfileRequest request) {
        Profiles profiles = profileRepository.findById(request.getId()).orElseThrow(
                () -> new UsernameNotFoundException("Profiles not founds")
        );
        profiles.setIsDeleted(true);
        profileRepository.save(profiles);
        return ResponseUtil.getSuccessfulServerResponse("Profile deleted successfully.");
    }

    @Override
    public ApiResponse<?> updateProfile(ProfileUpdateDto request) {
        Profiles profiles = profileRepository.findById(request.getId()).orElseThrow(
                () -> new UsernameNotFoundException("Profile not found.")
        );
        if (profiles == null) {
            return ResponseUtil.getFailureResponse("Profiles not found.");
        }

        Profiles profiles1 = requestToEntity.requestToEntity(profiles, request);
        profileRepository.save(profiles1);
        return ResponseUtil.getSuccessfulServerResponse("Profile updated successfully", 201);
    }

    @Override
    public ApiResponse<?> getProfilesByCategory(ProfileCategoryRequest category) {
        List<Profiles> profiles = profileRepository.findByCategoryOrderByPriorityAsc(category.getCategoryName());
//        if (profiles.isEmpty()) {
//            return ResponseUtil.getFailureResponse("Failed to fetch profiles by category: " + category.getCategoryName());
//        }
        List<ProfileResponse> profileResponse = profileMapper.getProfileResponse(profiles);
        return ResponseUtil.getSuccessfulServerResponse(profileResponse, "Profiles fetched successfully.", 200);
    }

    @Override
    public ApiResponse<?> getProfilesByPosition(ProfilePositionRequest positionRequest) {
        List<Profiles> byPosition = profileRepository.findByPosition(positionRequest.getPositionName());
        if (byPosition.isEmpty()) {
            return ResponseUtil.getFailureResponse("Failed to fetch data by position: " + positionRequest.getPositionName());
        }
        List<ProfileResponse> profileResponse = profileMapper.getProfileResponse(byPosition);
        return ResponseUtil.getSuccessfulServerResponse(profileResponse, "Profiles fetched successfully.", 200);
    }


}
