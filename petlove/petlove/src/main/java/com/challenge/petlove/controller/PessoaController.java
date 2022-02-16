package com.challenge.petlove.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.petlove.model.Pessoa;

@RequestMapping("/pessoas")
@RestController
public class PessoaController {

	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> findAllDesc(){
		return pessoaService.buscaPessoasEOrdenaDesc();
	}
}
