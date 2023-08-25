package com.ag.petclinicAG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;

@SpringBootApplication
@EnableEnversRepositories
public class PetclinicAgApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetclinicAgApplication.class, args);
	}

}
