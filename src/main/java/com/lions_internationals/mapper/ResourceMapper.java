package com.lions_internationals.mapper;

import com.lions_internationals.dto.response.ResourceResponse;
import com.lions_internationals.entitiy.Resources;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ResourceMapper {
    public abstract ResourceResponse mapEntityToResponse(Resources resources);
    public List<ResourceResponse> getAllResponse(List<Resources> resources){
        return resources.stream().map(this::mapEntityToResponse).collect(Collectors.toList());
    }
}
