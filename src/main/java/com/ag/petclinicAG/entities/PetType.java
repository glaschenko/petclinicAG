package com.ag.petclinicAG.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Audited
@Getter
@Setter
@Entity
@Table(name = "pet_type")
public class PetType extends NamedEntity{

    @Column(name = "color", nullable = false)
    private String color;

    @Override
    public String toString() {
        return "PetType: "+ color + " " + getName();
    }
}