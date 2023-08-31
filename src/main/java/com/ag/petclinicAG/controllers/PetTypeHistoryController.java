package com.ag.petclinicAG.controllers;

import com.ag.petclinicAG.entities.PetType;
import com.ag.petclinicAG.entities.envers.AuditEnversInfo;
import com.ag.petclinicAG.dto.PetTypeHistoryDto;
import com.ag.petclinicAG.mappers.PetTypeHistoryMapper;
import com.ag.petclinicAG.repositories.PetTypeRevisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.history.Revisions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet-type-history")
@RequiredArgsConstructor
public class PetTypeHistoryController {

    private final PetTypeRevisionRepository petTypeRevisionRepository;
    private final PetTypeHistoryMapper mapper;

    @GetMapping("/{id}")
    public List<PetTypeHistoryDto> findRevisions(@PathVariable Long id) {
        Revisions<Integer, PetType> revisions = petTypeRevisionRepository.findRevisions(id);
        List<PetTypeHistoryDto> result = new ArrayList<>();
        revisions.stream().forEach(r -> {
            PetTypeHistoryDto dto = mapper.toDto(r.getEntity());
            dto.setRevisionTimestamp(Date.from(r.getRequiredRevisionInstant()));
            dto.setRevisionType(r.getMetadata().getRevisionType());
            AuditEnversInfo delegate = r.getMetadata().getDelegate();
            dto.setUsername(delegate.getUsername());
            result.add(dto);
        });
        return result;
    }
}

