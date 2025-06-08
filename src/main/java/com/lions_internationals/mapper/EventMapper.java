package com.lions_internationals.mapper;

import com.lions_internationals.dto.AddEventDto;
import com.lions_internationals.dto.UpdateEventRequest;
import com.lions_internationals.dto.response.EventResponse;
import com.lions_internationals.entitiy.Events;
import org.mapstruct.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class EventMapper {

    public abstract Events mapToEvent(AddEventDto addEventDto);
    @AfterMapping
    protected void afterMapping(@MappingTarget Events events) {
        events.setIsDeleted(false);      // Set default value for isDeleted
        Date now = new Date();
        events.setCreatedAt(now);        // Set current timestamp
        events.setUpdatedAt(now);        // Set current timestamp
    }

    public abstract EventResponse entityToResponse(Events events);
    public List<EventResponse> getEventsResponse(List<Events> events) {
        return events.stream().map(this::entityToResponse).collect(Collectors.toList());
    }


    public Events mapUpdateRequest(UpdateEventRequest request, Events events){
        events.setTitle(request.getTitle());
        events.setEventTime(request.getEventTime());
        events.setDescription(request.getDescription());
        events.setLocation(request.getLocation());
        request.setEventDate(request.getEventDate());
        events.setUpdatedAt(new Date());

        return events;
    }
}
