package com.ag.petclinicAG.integration;

import com.ag.petclinicAG.PetclinicAgApplication;
import com.ag.petclinicAG.controllers.PetTypeController;
import com.ag.petclinicAG.entities.PetType;
import com.ag.petclinicAG.repositories.PetTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(
        classes = PetclinicAgApplication.class
)
public class PetTypeControllerIntegrationTest {
    @Autowired
    PetTypeController petTypeController;

    @Autowired
    PetTypeRepository petTypeRepository;

    @Test
    public void testLoadPets() {
        List<PetType> pets = petTypeController.findAll();
        for (PetType pet : pets) {
            System.out.println(pet);
        }

    }

    @Test
    public void testDeleteEntity() {
        petTypeRepository.deleteById(102L);
    }
}
