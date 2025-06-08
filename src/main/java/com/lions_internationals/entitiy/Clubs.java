package com.lions_internationals.entitiy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clubs")
public class Clubs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "club_name", nullable = false)
    private String clubName;

    @Column(name = "club_id", unique = true, nullable = false)
    private String clubId;


    @Column(name = "chartered_date", nullable = false)
    private Date charteredDate;

    @Column(name = "member", nullable = false)
    private Long member;

    @Column(name = "district_multiple")
    private String districtMultiple;

    @Column(name = "extension_chairperson")
    private String extensionChairperson;

    @Column(name = "guiding_lion_one")
    private String guidingLionOne;

    @Column(name = "guiding_lion_two")
    private String guidingLionTwo;

    @Column(name = "total_member")
    private Long totalMember;

    @Column(name = "member_added")
    private Long addedMember;

    @Column(name = "member_dropped")
    private Long droppedMember;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Lob
    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}

