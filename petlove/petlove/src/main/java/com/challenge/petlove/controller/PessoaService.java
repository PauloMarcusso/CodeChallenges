package com.challenge.petlove.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.petlove.model.Animal;
import com.challenge.petlove.model.Pessoa;
import com.challenge.petlove.repository.AnimalRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public List<Pessoa> buscaPessoasEOrdenaDesc() {
		List<Animal> animaisOrdenadosDesc = animalRepository.ordenaAnimaisPorCustoMensalDesc();
		
		List<Pessoa> pessoasOrdenadas = new ArrayList<>();
		for (Animal animal : animaisOrdenadosDesc) {
			pessoasOrdenadas.add(animal.getPessoa());
		}
		return pessoasOrdenadas;
	}

}
