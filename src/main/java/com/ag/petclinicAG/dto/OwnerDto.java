package com.ag.petclinicAG.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ag.petclinicAG.entities.Owner}
 */
@Value
public class OwnerDto implements Serializable {
    String firstName;
    String lastName;
    String city;
    String email;
}