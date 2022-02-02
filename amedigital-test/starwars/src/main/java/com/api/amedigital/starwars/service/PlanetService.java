package com.api.amedigital.starwars.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.api.amedigital.starwars.exception.PlanetDomainException;
import com.api.amedigital.starwars.model.Planet;
import com.api.amedigital.starwars.model.SwapiResponse;
import com.api.amedigital.starwars.model.dto.PlanetDTO;
import com.api.amedigital.starwars.repository.PlanetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlanetService {

	private String RESOURCE_PATH = "planets/";
	private static final String BASE_URL = "https://swapi.dev/api/";

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private PlanetRepository planetRepository;
	@Autowired
	RestTemplate restTemplate;

	@Transactional
	public PlanetDTO save(PlanetDTO planetaDto) {
		List<Planet> planetas = new ArrayList<>();

		Planet planeta = new Planet();
		planeta.setClimate(planetaDto.getClimate());
		planeta.setName(planetaDto.getName());
		planeta.setTerrain(planetaDto.getTerrain());

		SwapiResponse responseJson = listarApi();
		planetas.addAll(responseJson.getResults());

		for (Planet p : planetas) {
			if (p.getName().contains(planetaDto.getName())) {
				planeta.setFilms(p.getFilms());
			}
		}

		planetRepository.saveAndFlush(planeta);

		PlanetDTO novo = new PlanetDTO(planeta);

		return novo;
	}

	public Page<PlanetDTO> findAll(Pageable pageable, String name) throws PlanetDomainException {
		if (name != null) {
			Page<Planet> planetName = findByName(name, pageable);
			Page<PlanetDTO> planetDto = planetName.map(p -> new PlanetDTO(p));
			return planetDto;
		}
		Page<Planet> planetas = planetRepository.findAll(pageable);
		Page<PlanetDTO> page = planetas.map(p -> new PlanetDTO(p));
		return page;
	}

	public Page<Planet> findByName(String nome, Pageable pageable) throws PlanetDomainException {

		Page<Planet> planet = planetRepository.findByNameContaining(nome, pageable);

		if (planet == null) {
			throw new PlanetDomainException("Planeta com nome " + nome + "não encontrado");
		}

		return planet;

	}

	public PlanetDTO findById(Long id) throws PlanetDomainException {
		Planet planet = planetRepository.findById(id).get();

		if (planet == null) {
			throw new PlanetDomainException("Planeta com id " + id + "não encontrado");
		}

		return new PlanetDTO(planet);
	}

	@Transactional
	public void delete(Long id) throws PlanetDomainException {
		Planet planeta = planetRepository.findById(id).get();
		if (planeta == null) {
			throw new PlanetDomainException("Planeta com id " + id + "não existe");
		}
		planetRepository.delete(planeta);
		planetRepository.flush();
	}

	private SwapiResponse listarApi() {
		SwapiResponse response = restTemplate.getForObject(BASE_URL + RESOURCE_PATH, SwapiResponse.class);
		return response;
	}

}
