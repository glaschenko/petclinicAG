package com.ag.petclinicAG.repositories;

import com.ag.petclinicAG.entities.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
    List<PetType> findByNameContains(String name);

}