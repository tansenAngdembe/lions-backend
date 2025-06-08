package com.lions_internationals.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClubResponse {
    private Long id;
    private String clubName;
    private String clubId;
    private Date charteredDate;
    private Long member;
    private String districtMultiple;
    private String extensionChairperson;
    private String guidingLionOne;
    private String guidingLionTwo;
    private Long totalMember;
    private Long addedMember;
    private Long droppedMember;
    private Boolean isDeleted;
    private String logoUrl;
}
