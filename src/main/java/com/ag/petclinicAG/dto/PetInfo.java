package com.ag.petclinicAG.dto;

import com.ag.petclinicAG.entities.Pet;

import java.time.LocalDate;

/**
 * Projection for {@link Pet}
 */
public interface PetInfo {
    Long getId();

    String getName();

    LocalDate getBirthDate();

    PetTypeInfo getPetType();
}