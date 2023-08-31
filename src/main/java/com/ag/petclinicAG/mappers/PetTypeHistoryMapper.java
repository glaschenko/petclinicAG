package com.ag.petclinicAG.mappers;

import com.ag.petclinicAG.dto.PetTypeHistoryDto;
import com.ag.petclinicAG.entities.PetType;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetTypeHistoryMapper {
    PetType toEntity(PetTypeHistoryDto petTypeDto);

    PetTypeHistoryDto toDto(PetType petType);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    PetType partialUpdate(PetTypeHistoryDto petTypeDto, @org.mapstruct.MappingTarget PetType petType);
}