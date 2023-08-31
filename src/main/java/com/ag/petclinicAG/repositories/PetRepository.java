package com.ag.petclinicAG.repositories;

import com.ag.petclinicAG.entities.Pet;
import com.ag.petclinicAG.dto.PetInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface PetRepository extends PagingAndSortingRepository<Pet, Long>,
        JpaSpecificationExecutor<Pet> {
    PetInfo findByNameContains(@NonNull String name);

    List<PetInfo> findByPetType_ColorContainsOrderByNameAsc(String color, Pageable pageable);

    List<Pet> findAll();
}