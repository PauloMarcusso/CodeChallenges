package com.api.amedigital.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.amedigital.starwars.exception.PlanetDomainException;
import com.api.amedigital.starwars.model.dto.PlanetDTO;
import com.api.amedigital.starwars.service.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {

	@Autowired
	private PlanetService planetService;

	@GetMapping
	public Page<PlanetDTO> findAll(Pageable pageable, @RequestParam(value = "name", required = false) String name) throws PlanetDomainException {
		return planetService.findAll(pageable, name);
	}

//	@GetMapping
//	public PlanetDTO findByName() throws PlanetDomainException {
//		return planetService.findByName(name);
//	}
	
	@GetMapping("/{id}")
	public PlanetDTO findById(@PathVariable Long id) throws PlanetDomainException {
		return planetService.findById(id);
	}

	@PostMapping
	public ResponseEntity<PlanetDTO> save(@RequestBody PlanetDTO dto) throws Exception {
		PlanetDTO planetaDto = planetService.save(dto);
		return ResponseEntity.ok(planetaDto).status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) throws PlanetDomainException {
		planetService.delete(id);
	}

}
