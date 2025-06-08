package com.lions_internationals.service;

import com.lions_internationals.dto.ClubDto;
import com.lions_internationals.dto.ClubUpdateDto;
import com.lions_internationals.dto.request.ClubRequest;
import com.lions_internationals.util.api.ApiResponse;

public interface ClubService {
    ApiResponse<?> addClub(ClubDto request);
    ApiResponse<?> getAllClub();
    ApiResponse<?> getClub(ClubRequest request);
    ApiResponse<?> deleteClub(ClubRequest request);
    ApiResponse<?> permanentDeleteClub(ClubRequest request);

    ApiResponse<?> updateClub(ClubUpdateDto clubUpdateDto);
}
