package com.lions_internationals.mapper;

import com.lions_internationals.dto.ProfileUpdateDto;
import com.lions_internationals.dto.request.ProfileAdd;
import com.lions_internationals.entitiy.Profiles;
import com.lions_internationals.util.service.FileService;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class RequestToProfileMapper {

    @Autowired
    private FileService fileService;


    public Profiles requestToEntity(ProfileAdd request) {
        Profiles profile = new Profiles();
        profile.setFullName(request.getFullName());
        profile.setEmail(request.getEmail());
        profile.setAddress(request.getAddress());
        profile.setPosition(request.getPosition());
        profile.setPhoneNumber(request.getPhoneNumber());
        profile.setMemberNumber(request.getMemberNumber());
        profile.setImage(fileService.uploadImage(request.getImage()));

        // Conditional mapping
        profile.setCategory(request.getCategory() != null ? request.getCategory() : "N/A");
        profile.setIsDeleted(false);
        profile.setPriority(request.getPriority());

        // Set current date
        Date currentDate = new Date();
        profile.setCreatedAt(currentDate);
        profile.setUpdatedAt(currentDate);


        return profile;
    }

    public Profiles requestToEntity(Profiles profile,ProfileUpdateDto request) {

        // Basic attribute mapping
        profile.setId(request.getId());
        profile.setFullName(request.getFullName());
        profile.setEmail(request.getEmail());
        profile.setAddress(request.getAddress());
        profile.setPosition(request.getPosition());
        profile.setPhoneNumber(request.getPhoneNumber());
        profile.setMemberNumber(request.getMemberNumber());
        if (request.getImage() != null){
            profile.setImage(fileService.uploadImage(request.getImage()));
        }
        // Conditional mapping
        profile.setCategory(request.getCategory() != null ? request.getCategory() : "N/A");
        profile.setIsDeleted(false);
        profile.setPriority(request.getPriority());

        // Set current date
        profile.setUpdatedAt(new Date());

        return profile;
    }
}
