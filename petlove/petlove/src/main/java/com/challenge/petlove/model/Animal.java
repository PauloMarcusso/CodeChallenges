package com.challenge.petlove.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal custoMensal;
	private String tipo;
	
	@JsonIgnoreProperties
	@ManyToOne()
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	public Animal() {}

	public Animal(String nome, BigDecimal custoMensal, String tipo) {
		super();
		this.nome = nome;
		this.custoMensal = custoMensal;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getCustoMensal() {
		return custoMensal;
	}

	public void setCustoMensal(BigDecimal custoMensal) {
		this.custoMensal = custoMensal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", custoMensal=" + custoMensal + ", tipo=" + tipo + ", pessoa="
				+ pessoa + "]";
	}
	
	
}
