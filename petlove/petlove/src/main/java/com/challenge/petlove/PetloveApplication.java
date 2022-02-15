package com.challenge.petlove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.challenge.petlove.service.AnimalService;

@SpringBootApplication
public class PetloveApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetloveApplication.class, args);
	}

}
