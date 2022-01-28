package com.api.amedigital.starwars.model.dto;

import com.api.amedigital.starwars.model.Planeta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PlanetaDTO {

	String nome;
	String clima;
	String terreno;
	
	public PlanetaDTO(Planeta planeta) {
		nome = planeta.getName();
		clima = planeta.getClimate();
		terreno = planeta.getTerrain();
	}
}
