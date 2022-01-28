package com.api.amedigital.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.amedigital.starwars.model.Planeta;
import com.api.amedigital.starwars.model.dto.PlanetaDTO;

@Repository
public interface PlanetRepository extends JpaRepository<Planeta, String>{

	PlanetaDTO findByName(String name);
}
