package com.ag.petclinicAG.controllers;

import com.ag.petclinicAG.entities.PetType;
import com.ag.petclinicAG.repositories.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pettypes")
@RequiredArgsConstructor
public class PetTypeController {

    private final PetTypeRepository petTypeRepository;

    @PostMapping
    public PetType save(@RequestBody PetType entity) {
        return petTypeRepository.save(entity);
    }

    @GetMapping
    public List<PetType> findAll() {
        return petTypeRepository.findAll();
    }
}

