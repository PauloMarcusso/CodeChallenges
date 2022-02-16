package com.challenge.petlove.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.petlove.model.Animal;
import com.challenge.petlove.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	public BigDecimal calcularCustoMedio(String tipo) {
		
		checaSeTipoExiste(tipo);
		
		return animalRepository.custoMedio(tipo);
	}


	public Integer buscaQuantidadePorTipo(String tipo) {
		return animalRepository.quantidadePorTipo(tipo);
	}
	
	public List<Animal> findAll() {
		return animalRepository.findAll();
	}
	
	
	public List<String> buscaDonoPorTipo(String tipo) {
		checaSeTipoExiste(tipo);
//		List<String> donosDosAnimais = new ArrayList<>();
//		for (Animal animal : findAll()) {
//			if(animal.getTipo().contains(tipo)) {
//				donosDosAnimais.add(animal.getPessoa().getNome());
//			}
//		}
	List<String> donosDosAnimais = animalRepository.buscaDonoPorTipo(tipo);
		return donosDosAnimais;
	}
	
	private boolean checaSeTipoExiste(String nome) {
		List<Animal> tipo = animalRepository.findByTipo(nome);		
		if (tipo.isEmpty()) {
			throw new RuntimeException("Não existe animal desse tipo");
		}		
		return true;
	}

}
