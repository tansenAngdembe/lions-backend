package com.lions_internationals.service.impl;

import com.lions_internationals.dto.AddEventDto;
import com.lions_internationals.dto.UpdateEventRequest;
import com.lions_internationals.dto.request.EventRequest;
import com.lions_internationals.dto.response.EventResponse;
import com.lions_internationals.entitiy.Events;
import com.lions_internationals.exception.ResourceNotFoundException;
import com.lions_internationals.mapper.EventMapper;
import com.lions_internationals.repository.EventRepository;
import com.lions_internationals.service.EventService;
import com.lions_internationals.util.ResponseUtil;
import com.lions_internationals.util.api.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventMapper eventMapper;
    private final EventRepository eventRepository;

    public EventServiceImpl(EventMapper eventMapper, EventRepository eventRepository) {
        this.eventMapper = eventMapper;
        this.eventRepository = eventRepository;

    }

    @Override
    public ApiResponse<?> addEvent(AddEventDto addEventDto) {
        Events events = eventMapper.mapToEvent(addEventDto);
        eventRepository.save(events);
        return ResponseUtil.getSuccessfulServerResponse("Event added successfully. ", 201);
    }

    @Override
    public ApiResponse<?> getEvent(EventRequest request) {
        Events event = eventRepository.findById(request.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Event not found.")
        );
        if (event == null){
            return ResponseUtil.getFailureResponse("Failed to fetch event");
        }
        EventResponse eventResponse = eventMapper.entityToResponse(event);
        return ResponseUtil.getSuccessfulServerResponse(eventResponse, "Event fetched successfully.", 200);
    }

    @Override
    public ApiResponse<?> getAllEvent() {
        List<Events> all = eventRepository.findByIsDeletedFalse();
        List<EventResponse> eventsResponse = eventMapper.getEventsResponse(all);
        return ResponseUtil.getSuccessfulServerResponse(eventsResponse, "Events fetched successfully.", 200);
    }

    @Override
    public ApiResponse<?> deleteEvent(EventRequest request) {
        Events events = eventRepository.findByIdAndIsDeletedFalse(request.getId());

        if (events == null) {
            return ResponseUtil.getFailureResponse("Failed to delete or Event not found with id " + request.getId());
        }
        events.setIsDeleted(true);
        events.setUpdatedAt(new Date());
        eventRepository.save(events);
        return ResponseUtil.getSuccessfulServerResponse("Event deleted successfully", 201);
    }

    @Override
    public ApiResponse<?> updateEvent(UpdateEventRequest request) {
        Events events = eventRepository.findById(request.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Event not found.")
        );
        Events newEvent = eventMapper.mapUpdateRequest(request, events);
        eventRepository.save(newEvent);
        return ResponseUtil.getSuccessfulServerResponse("Event updated successfully.", 201);
    }

}
