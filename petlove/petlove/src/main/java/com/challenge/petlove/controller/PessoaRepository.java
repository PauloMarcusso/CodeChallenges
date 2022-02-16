package com.challenge.petlove.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.petlove.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("SELECT p FROM Pessoa p, Animal a ORDER BY a.custoMensal DESC ")
	List<Pessoa> buscaPessoaEOrdenaDesc();
}
