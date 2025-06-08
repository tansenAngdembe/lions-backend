package com.lions_internationals.service.impl;

import com.lions_internationals.dto.ClubDto;
import com.lions_internationals.dto.ClubUpdateDto;
import com.lions_internationals.dto.request.ClubRequest;
import com.lions_internationals.dto.response.ClubResponse;
import com.lions_internationals.entitiy.Clubs;
import com.lions_internationals.exception.ResourceNotFoundException;
import com.lions_internationals.mapper.ClubMapper;
import com.lions_internationals.repository.ClubRepository;
import com.lions_internationals.service.ClubService;
import com.lions_internationals.util.ResponseUtil;
import com.lions_internationals.util.api.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {
    private final ClubMapper clubMapper;
    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubMapper clubMapper, ClubRepository clubRepository) {
        this.clubMapper = clubMapper;
        this.clubRepository = clubRepository;
    }

    @Override
    public ApiResponse<?> addClub(ClubDto request) {
        Clubs clubs = clubMapper.mapToEntity(request);
        clubRepository.save(clubs);
        return ResponseUtil.getSuccessfulServerResponse("Club added successfully.", 201);
    }

    @Override
    public ApiResponse<?> getAllClub() {
        List<Clubs> clubs = clubRepository.findAllByIsDeletedFalse();
        if (clubs.isEmpty()){
            return ResponseUtil.getFailureResponse("List is empty, or fail to fetch.");
        }
        List<ClubResponse> clubsResponse = clubMapper.getClubsResponse(clubs);
        return ResponseUtil.getSuccessfulServerResponse(clubsResponse, "Clubs fetched successfully", 200);
    }

    @Override
    public ApiResponse<?> getClub(ClubRequest request) {
        Clubs club = clubRepository.findById(request.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Club not found with id " + request.getId())
        );
        if (club == null) {
            return ResponseUtil.getFailureResponse("Failed to fetch club.");
        }
        ClubResponse clubResponse = clubMapper.mapEntityToResponse(club);
        return ResponseUtil.getSuccessfulServerResponse(clubResponse, "Club fetched successfully.", 200);
    }

    // Delete club (change delete-flag).
    @Override
    public ApiResponse<?> deleteClub(ClubRequest request) {
        Clubs club = clubRepository.findById(request.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Club not found with id " + request.getId())
        );
        if (club == null){
            return ResponseUtil.getFailureResponse("Failed to update club. or club not found");
        }
        club.setIsDeleted(true);
        club.setUpdatedAt(new Date());
        clubRepository.save(club);
        return ResponseUtil.getSuccessfulServerResponse("Club deleted successfully.");
    }

    // Permanent Delete club
    @Override
    public ApiResponse<?> permanentDeleteClub(ClubRequest request) {
        clubRepository.deleteById(request.getId());
        return ResponseUtil.getSuccessfulServerResponse("Club deleted successfully", 203);
    }

    @Override
    public ApiResponse<?> updateClub(ClubUpdateDto clubUpdateDto) {
        Clubs clubs = clubRepository.findById(clubUpdateDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Club not found with id " + clubUpdateDto.getId())
        );
        Clubs newClub = clubMapper.mapUpdateToEntity(clubUpdateDto, clubs);
        clubRepository.save(newClub);

        return ResponseUtil.getSuccessfulServerResponse("Club updated successfully.", 201);
    }
}
