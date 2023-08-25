package com.ag.petclinicAG.controllers;

import com.ag.petclinicAG.entities.PetType;
import com.ag.petclinicAG.repositories.PetTypeRevisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.history.Revisions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pet-type-history")
@RequiredArgsConstructor
public class PetTypeHistoryController {

    private final PetTypeRevisionRepository petTypeRevisionRepository;

    @GetMapping("/{id}")
    public Revisions<Integer, PetType> findRevisions(@PathVariable Long id) {
        return petTypeRevisionRepository.findRevisions(id);
    }
}

