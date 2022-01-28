package com.api.amedigital.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.amedigital.starwars.model.Planeta;
import com.api.amedigital.starwars.model.dto.PlanetaDTO;
import com.api.amedigital.starwars.service.PlanetaService;

@RestController
@RequestMapping("/planets")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;

	@PostMapping
	public ResponseEntity<PlanetaDTO> adicionar(@RequestBody PlanetaDTO dto) {
		PlanetaDTO planetaDto = planetaService.salvar(dto);
		return ResponseEntity.ok(planetaDto);
	}
}
