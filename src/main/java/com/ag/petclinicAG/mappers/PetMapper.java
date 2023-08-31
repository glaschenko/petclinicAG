package com.ag.petclinicAG.mappers;

import com.ag.petclinicAG.dto.PetDto;
import com.ag.petclinicAG.entities.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetMapper {
    PetDto toDto(Pet pet);
}