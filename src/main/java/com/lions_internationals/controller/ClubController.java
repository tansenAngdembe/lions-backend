package com.lions_internationals.controller;

import com.lions_internationals.dto.ClubDto;
import com.lions_internationals.dto.ClubUpdateDto;
import com.lions_internationals.dto.request.ClubRequest;
import com.lions_internationals.service.ClubService;
import com.lions_internationals.service.impl.ClubServiceImpl;
import com.lions_internationals.util.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/clubs")
public class ClubController {
    private final ClubService clubService;

    @PostMapping("/add")
    public ApiResponse<?> addClub(@ModelAttribute ClubDto request){
        return clubService.addClub(request);
    }

    @PostMapping("/getAll")
    public ApiResponse<?> getAllClub() {
        return clubService.getAllClub();
    }

    @PostMapping("/get")
    public ApiResponse<?> getClub(@RequestBody ClubRequest request) {
        return clubService.getClub(request);
    }

    @PostMapping("/delete")
    public ApiResponse<?> deleteClub(@RequestBody ClubRequest request) {
        return clubService.deleteClub(request);
    }

    @PostMapping("/permanentDelete")
    public ApiResponse<?> permanentDeleteClub(@RequestBody ClubRequest request) {
        return clubService.permanentDeleteClub(request);
    }

    @PostMapping("/update")
    public ApiResponse<?> updateClub(@ModelAttribute ClubUpdateDto clubUpdateDto) {
        return clubService.updateClub(clubUpdateDto);
    }





}
