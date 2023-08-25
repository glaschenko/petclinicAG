package com.ag.petclinicAG.repositories;

import com.ag.petclinicAG.entities.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface PetTypeRevisionRepository extends JpaRepository<PetType, Long>,
        RevisionRepository<PetType, Long, Integer> {
}