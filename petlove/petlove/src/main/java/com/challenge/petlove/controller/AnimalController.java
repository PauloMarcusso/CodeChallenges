package com.challenge.petlove.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.petlove.model.Animal;
import com.challenge.petlove.service.AnimalService;

@RequestMapping("/animais")
@RestController
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;

	@GetMapping
	public List<Animal> findAll(){
		return animalService.findAll();
	}
	
	@GetMapping("/{nome}")
	public BigDecimal custoMedio(@PathVariable String nome) {
		return animalService.calcularCustoMedio(nome);
	}
}
