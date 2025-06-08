package com.lions_internationals.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "member_number", nullable = false)
    private String memberNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Lob
    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "created_at", columnDefinition = "LONGTEXT", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
}
