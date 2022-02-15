package com.challenge.petlove.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.petlove.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	@Query("SELECT AVG(a.custoMensal) FROM Animal a WHERE a.tipo = :tipo")
	BigDecimal custoMedio(@Param("tipo") String tipo);

	List<Animal> findByTipo(String nome);
	
}
