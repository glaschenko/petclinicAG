package com.ag.petclinicAG.mappers;

import com.ag.petclinicAG.dto.PetTypeDto;
import com.ag.petclinicAG.entities.PetType;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetTypeMapper {
    PetType toEntity(PetTypeDto petTypeDto);

    PetTypeDto toDto(PetType petType);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    PetType partialUpdate(PetTypeDto petTypeDto, @org.mapstruct.MappingTarget PetType petType);
}