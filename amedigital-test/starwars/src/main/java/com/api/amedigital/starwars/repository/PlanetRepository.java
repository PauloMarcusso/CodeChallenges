package com.api.amedigital.starwars.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.amedigital.starwars.model.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long>{

	Page<Planet> findByNameContaining(String name, Pageable pageable);

}
