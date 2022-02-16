package com.challenge.petlove.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.petlove.model.Animal;
import com.challenge.petlove.model.Pessoa;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	@Query("SELECT AVG(a.custoMensal) FROM Animal a WHERE a.tipo = :tipo")
	BigDecimal custoMedio(@Param("tipo") String tipo);

	@Query("SELECT COUNT(a.tipo) FROM Animal a WHERE a.tipo = :tipo")
	Integer quantidadePorTipo(String tipo);

	@Query("SELECT DISTINCT a.pessoa.nome FROM Animal a, Pessoa p WHERE a.tipo = :tipo")
	List<String> buscaDonoPorTipo(String tipo);
	
	@Query("SELECT a FROM Animal a ORDER BY a.custoMensal DESC ")
	List<Animal> ordenaAnimaisPorCustoMensalDesc();
	
	List<Animal> findByTipo(String nome);
	
}
