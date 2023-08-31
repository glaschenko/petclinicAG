package com.ag.petclinicAG.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.ag.petclinicAG.entities.PetType} entity
 */
@Data
public class PetTypeDto implements Serializable {
    private Long id;
    private String name;
    private String color;
}