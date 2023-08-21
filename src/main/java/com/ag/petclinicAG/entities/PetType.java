package com.ag.petclinicAG.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pet_type")
public class PetType extends NamedEntity{

    @Column(name = "color", nullable = false)
    private String color;

}