package com.challenge.petlove.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.petlove.model.Animal;
import com.challenge.petlove.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	public BigDecimal calcularCustoMedio(String nome) {
		
		checaSeTipoExiste(nome);
		
		return animalRepository.custoMedio(nome);
	}

	private boolean checaSeTipoExiste(String nome) {
		List<Animal> tipo = animalRepository.findByTipo(nome);
		
		if (tipo.isEmpty()) {
			throw new RuntimeException("Não existe animal desse tipo");
		}
		
		return true;
	}

	public List<Animal> findAll() {
		return animalRepository.findAll();
	}
}
