package com.lions_internationals.controller;

import com.lions_internationals.dto.publicRequest.ProfileCategoryRequest;
import com.lions_internationals.dto.request.ClubRequest;
import com.lions_internationals.dto.request.EventRequest;
import com.lions_internationals.service.ClubService;
import com.lions_internationals.service.EventService;
import com.lions_internationals.service.ProfileService;
import com.lions_internationals.service.ResourceService;
import com.lions_internationals.util.api.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public")
public class PublicController {


    private final ClubService clubService;
    private final EventService eventService;
    private final ProfileService profileService;
    private final ResourceService resourceService;

    public PublicController(ClubService clubService, EventService eventService, ProfileService profileService, ResourceService resourceService) {
        this.clubService = clubService;
        this.eventService = eventService;
        this.profileService = profileService;
        this.resourceService = resourceService;
    }

    @PostMapping("/get-all-clubs")
    public ApiResponse<?> getAllClubs() {
        return clubService.getAllClub();
    }

    @PostMapping("/get-club")
    public ApiResponse<?> getClub(@RequestBody ClubRequest request){
        return clubService.getClub(request);
    }

    @PostMapping("/get-all-events")
    public ApiResponse<?> getAllEvents() {
        return eventService.getAllEvent();
    }

    @PostMapping("/get-event")
    public ApiResponse<?> getEvent(@RequestBody EventRequest request) {
        return eventService.getEvent(request);
    }

    @PostMapping("/get-profiles-by-category")
    public ApiResponse<?> getProfileByCategory(@RequestBody ProfileCategoryRequest category) {
        return profileService.getProfilesByCategory(category);
    }
    @PostMapping("/get-resources")
    public ApiResponse<?> getResources() {
        return  resourceService.getAll();
    }


}
