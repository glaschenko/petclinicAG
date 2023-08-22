package com.ag.petclinicAG.integration;

import com.ag.petclinicAG.PetclinicAgApplication;
import com.ag.petclinicAG.controllers.PetTypeController;
import com.ag.petclinicAG.entities.PetType;
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

    @Test
    public void testLoadPets() {
        List<PetType> pets = petTypeController.findAll();
        for (PetType pet : pets) {
            System.out.println(pet);
        }

    }
}
