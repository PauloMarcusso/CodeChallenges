package com.api.amedigital.starwars.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.api.amedigital.starwars.model.Planet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetDTO {

	private String name;
	private String climate;
	private String terrain;
	private List<String> films = new ArrayList<>();
	
	public PlanetDTO(Planet planeta) {
		name = planeta.getName();
		climate = planeta.getClimate();
		terrain = planeta.getTerrain();
		films = planeta.getFilms();
	}
}
