package com.ag.petclinicAG.controllers;

import com.ag.petclinicAG.dto.PetDto;
import com.ag.petclinicAG.dto.PetInfo;
import com.ag.petclinicAG.entities.Pet;
import com.ag.petclinicAG.entities.specifications.PetSpecifications;
import com.ag.petclinicAG.mappers.PetMapper;
import com.ag.petclinicAG.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @GetMapping("/{name}")
    public ResponseEntity<PetInfo> findByNameLike(@PathVariable String name) {
        PetInfo petInfo = petRepository.findByNameContains(name);
        return ResponseEntity.ok(petInfo);
    }

    @GetMapping({"/color/{color}"})
    public List<PetInfo> findPetsByColor(@PathVariable String color, Pageable pageable) {
        return petRepository.findByPetType_ColorContainsOrderByNameAsc(color, pageable);
    }

    @GetMapping(path = {"/old"})
    public List<PetDto> findOldPets() {
        List<Pet> pets = petRepository.findAll(PetSpecifications.oldPets(13));
        List<PetDto> petDtos = pets.stream()
                .map(petMapper::toDto)
                .collect(Collectors.toList());
        return petDtos;
    }
}

