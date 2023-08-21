package com.ag.petclinicAG.repositories;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.ag.petclinicAG.entities.PetType} entity
 */
@Data
public class PetTypeDto implements Serializable {
    private final Long id;
    private final String name;
    private final String color;
}