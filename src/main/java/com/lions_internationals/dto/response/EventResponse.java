package com.lions_internationals.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventResponse {
    private Long id;
    private Date eventDate;
    private String title;
    private String location;
    private String eventTime;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
