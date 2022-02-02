package com.api.amedigital.starwars.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Planet() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String diameter;
	private String climate;
	private String gravity;
	private String orbital_period;
	private String population;
	private String rotation_period;
	private String surface_water;
	private String terrain;
	private String url;
	private String created;
	private String edited;	
	
	@ElementCollection(targetClass=String.class)
	List<String> residents = new ArrayList<String>();
	
	@ElementCollection(targetClass=String.class)
	List<String> films = new ArrayList<String>();
}
