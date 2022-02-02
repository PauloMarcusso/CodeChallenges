package com.api.amedigital.starwars.model;

import java.util.ArrayList;
import java.util.List;

import com.api.amedigital.starwars.model.dto.PlanetDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResponse {

	private Integer count;
	private String next;
	private String previous;
	private List<Planet> results = new ArrayList<>();
}
