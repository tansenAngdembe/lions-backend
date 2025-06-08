package com.lions_internationals.mapper;

import com.lions_internationals.dto.ClubDto;
import com.lions_internationals.dto.ClubUpdateDto;
import com.lions_internationals.dto.response.ClubResponse;
import com.lions_internationals.entitiy.Clubs;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ClubMapper {
    public Clubs mapToEntity(ClubDto dto) {
        Clubs club = new Clubs();
        club.setClubName(dto.getClubName());
        club.setClubId(dto.getClubId());
        club.setCharteredDate(dto.getCharteredDate());
        club.setMember(dto.getMember());
        club.setDistrictMultiple(dto.getDistrictMultiple());
        club.setExtensionChairperson(dto.getExtensionChairperson());
        club.setGuidingLionOne(dto.getGuidingLionOne());
        club.setGuidingLionTwo(dto.getGuidingLionTwo());
        club.setTotalMember(dto.getMember());
        club.setAddedMember(0L);
        club.setDroppedMember(0L);
        club.setIsDeleted(false);

        // Convert MultipartFile to Base64 String
        MultipartFile logoFile = dto.getLogoUrl();
        if (logoFile != null && !logoFile.isEmpty()) {
            try {
                byte[] bytes = logoFile.getBytes();
                String base64Logo = Base64.getEncoder().encodeToString(bytes);
                club.setLogoUrl(base64Logo);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Failed to convert image to Base64");
            }
        }
        return club;
    }

    public Clubs mapUpdateToEntity(ClubUpdateDto dto, Clubs clubs) {
        clubs.setClubName(dto.getClubName());
        clubs.setClubId(dto.getClubId());
        clubs.setCharteredDate(dto.getCharteredDate());
        clubs.setDistrictMultiple(dto.getDistrictMultiple());
        clubs.setExtensionChairperson(dto.getExtensionChairperson());
        clubs.setGuidingLionOne(dto.getGuidingLionOne());
        clubs.setGuidingLionTwo(dto.getGuidingLionTwo());
        clubs.setMember(dto.getMember());

        // Convert MultipartFile to Base64 String
        MultipartFile logoFile = dto.getLogoUrl();
        if (logoFile != null && !logoFile.isEmpty()) {
            try {
                byte[] bytes = logoFile.getBytes();
                String base64Logo = Base64.getEncoder().encodeToString(bytes);
                clubs.setLogoUrl(base64Logo);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Failed to convert image to Base64");
            }
        }
        clubs.setUpdatedAt(new Date());
        return clubs;

    }

    public abstract ClubResponse mapEntityToResponse(Clubs clubs);
    public List<ClubResponse> getClubsResponse(List<Clubs> clubs){
        return clubs.stream().map(this::mapEntityToResponse).collect(Collectors.toList());
    }

}
