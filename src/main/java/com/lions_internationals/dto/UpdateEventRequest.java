package com.lions_internationals.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateEventRequest {
    private Long id;
    private Date eventDate;
    private String title;
    private String location;
    private String eventTime;
    private String description;
}
