package com.lions_internationals.mapper;

import com.lions_internationals.dto.publicResponse.ProfileResponse;
import com.lions_internationals.entitiy.Profiles;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProfileMapper {

    public abstract com.lions_internationals.dto.response.ProfileResponse mapEntityToResponse(Profiles profiles);
    public List<com.lions_internationals.dto.response.ProfileResponse> getAllResponse(List<Profiles> profiles){
        return profiles.stream().map(this::mapEntityToResponse).collect(Collectors.toList());
    }

    public abstract ProfileResponse mapToProfileCategoryResponse(Profiles profiles);
    public List<ProfileResponse> getProfileResponse(List<Profiles> profiles) {
        return profiles.stream().map(this::mapToProfileCategoryResponse).collect(Collectors.toList());
    }


}
