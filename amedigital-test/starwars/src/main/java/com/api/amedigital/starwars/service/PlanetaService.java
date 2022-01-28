package com.api.amedigital.starwars.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.amedigital.starwars.model.Planeta;
import com.api.amedigital.starwars.model.dto.PlanetaDTO;
import com.api.amedigital.starwars.repository.PlanetRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetRepository planetRepository;

	@Transactional
	public PlanetaDTO salvar(PlanetaDTO planetaDto) {

		Planeta planeta = new Planeta();
		planeta.setClimate(planetaDto.getClima());
		planeta.setName(planetaDto.getNome());
		planeta.setTerrain(planetaDto.getTerreno());

		planetRepository.saveAndFlush(planeta);

		PlanetaDTO novo = new PlanetaDTO(planeta);

		return novo;
	}

	public Page<PlanetaDTO> listar(Pageable pageable) {
		Page<Planeta> planetas = planetRepository.findAll(pageable);
		Page<PlanetaDTO> page = planetas.map(p -> new PlanetaDTO(p));
		return page;
	}

	public PlanetaDTO buscarPorNome(String nome) {
		return planetRepository.findByName(nome);
	}

	@Transactional
	public void deletar(String nome) {
		Planeta planeta = planetRepository.findById(nome).get();
		planetRepository.delete(planeta);		
	}
}
