package com.ag.petclinicAG.entities.specifications;

import com.ag.petclinicAG.entities.Pet;
import com.ag.petclinicAG.entities.Pet_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class PetSpecifications {
    public static Specification<Pet> oldPets(final int age){
        return new Specification<Pet>() {
            @Override
            public Predicate toPredicate(Root<Pet> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThan(root.get(Pet_.birthDate),
                        LocalDate.now().minusYears(age));

            }
        };
    }
}
