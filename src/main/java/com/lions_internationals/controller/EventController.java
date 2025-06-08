package com.lions_internationals.controller;

import com.lions_internationals.dto.AddEventDto;
import com.lions_internationals.dto.UpdateEventRequest;
import com.lions_internationals.dto.request.EventRequest;
import com.lions_internationals.service.EventService;
import com.lions_internationals.util.api.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;

    }

    @PostMapping("/add")
    public ApiResponse<?> addEvent(@RequestBody AddEventDto addEventDto) {
        return eventService.addEvent(addEventDto);
    }

    @PostMapping("/getAll")
    public ApiResponse<?> getAllEvents() {
        return eventService.getAllEvent();
    }

    @PostMapping("/get")
    public ApiResponse<?> getEvent(@RequestBody EventRequest request) {
        return eventService.getEvent(request);
    }

    @PostMapping("/delete")
    public ApiResponse<?> deleteEvent(@RequestBody EventRequest request) {
        return eventService.deleteEvent(request);
    }

    @PostMapping("/update")
    public ApiResponse<?> updateEvent(@RequestBody UpdateEventRequest request) {
        return eventService.updateEvent(request);
    }
}
