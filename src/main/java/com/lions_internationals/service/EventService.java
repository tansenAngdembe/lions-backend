package com.lions_internationals.service;

import com.lions_internationals.dto.AddEventDto;
import com.lions_internationals.dto.UpdateEventRequest;
import com.lions_internationals.dto.request.EventRequest;
import com.lions_internationals.util.api.ApiResponse;

public interface EventService {
    ApiResponse<?> addEvent(AddEventDto addEventDto);
    ApiResponse<?> getEvent(EventRequest request);
    ApiResponse<?> getAllEvent();
    ApiResponse<?> deleteEvent(EventRequest request);
    ApiResponse<?> updateEvent(UpdateEventRequest request);
}
