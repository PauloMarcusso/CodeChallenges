package com.api.amedigital.starwars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.amedigital.starwars.model.dto.PlanetaDTO;
import com.api.amedigital.starwars.service.PlanetaService;

@RestController
@RequestMapping("/planets")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;
	
	@GetMapping
	public Page<PlanetaDTO> listar(Pageable pageable){
		return planetaService.listar(pageable);
	}
	
	@GetMapping("/{nome}")
	public PlanetaDTO buscarPorNome(@PathVariable String nome) {
		return planetaService.buscarPorNome(nome);
	}

	@PostMapping
	public ResponseEntity<PlanetaDTO> adicionar(@RequestBody PlanetaDTO dto) {
		PlanetaDTO planetaDto = planetaService.salvar(dto);
		return ResponseEntity.ok(planetaDto);
	}
	
	@DeleteMapping("/{nome}")
	public void excluir(@PathVariable String nome) {
		planetaService.deletar(nome);
	}
	
	
}
