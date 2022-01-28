package com.api.amedigital.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
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
}
