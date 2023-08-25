package com.ag.petclinicAG.controllers;

import com.ag.petclinicAG.entities.PetType;
import com.ag.petclinicAG.repositories.PetTypeDto;
import com.ag.petclinicAG.repositories.PetTypeHistoryMapper;
import com.ag.petclinicAG.repositories.PetTypeMapper;
import com.ag.petclinicAG.repositories.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationStartupAware;
import org.springframework.context.event.EventListener;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pettypes")
@RequiredArgsConstructor
public class PetTypeController implements ApplicationStartupAware {

    private final PetTypeRepository petTypeRepository;
    private final PetTypeMapper petTypeMapper;

    @PostMapping
    public PetType save(@RequestBody PetType entity) {
        return petTypeRepository.save(entity);
    }

    @GetMapping
    public List<PetType> findAll() {
        return petTypeRepository.findAll();
    }


    @Override
    public void setApplicationStartup(ApplicationStartup applicationStartup) {
        System.out.println("PetTypeController: application started!");
    }

    @EventListener
    public void handleAuthenticationSuccessEvent(AuthenticationSuccessEvent event) {
        System.out.println("PetTypeController: authentication successful!");
    }

    @EventListener
    public void handleServletWebServerInitializedEvent(ServletWebServerInitializedEvent event) {
        System.out.println("PetTypeController: running on port " + event.getWebServer().getPort());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{name}")
    public List<PetTypeDto> findByNameContains(@PathVariable String name) {
        List<PetTypeDto> petTypeDtos = petTypeRepository.findByNameContains(name).stream()
                .map(petTypeMapper::toDto)
                .collect(Collectors.toList());

        return petTypeDtos;
    }
    
    
}

