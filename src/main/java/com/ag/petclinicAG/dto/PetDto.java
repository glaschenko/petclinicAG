package com.ag.petclinicAG.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.ag.petclinicAG.entities.Pet}
 */
@Value
public class PetDto implements Serializable {
    String name;
    LocalDate birthDate;
    PetTypeDto petType;
    OwnerDto owner;
}