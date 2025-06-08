package com.lions_internationals.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddEventDto {
    private Date eventDate;
    private String title;
    private String location;
    private String eventTime;
    private String description;
}
