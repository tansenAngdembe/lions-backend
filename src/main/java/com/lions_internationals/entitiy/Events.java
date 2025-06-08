package com.lions_internationals.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_date", nullable = false)
    private Date eventDate;
    @Column(name = "event_title", nullable = false)
    private String title;
    @Column(name = "event_location", nullable = false)
    private String location;
    @Column (name = "event_time", nullable = false)
    private String eventTime;
    @Column(name = "event_description", nullable = false)
    private String description;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
}
