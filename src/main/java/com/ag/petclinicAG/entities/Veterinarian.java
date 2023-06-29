package com.ag.petclinicAG.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "veterinarian")
public class Veterinarian extends Person {
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "veterinarian_specialities",
            joinColumns = @JoinColumn(name = "veterinarian_id"),
            inverseJoinColumns = @JoinColumn(name = "specialities_id"))
    private Set<Speciality> specialities = new LinkedHashSet<>();

}