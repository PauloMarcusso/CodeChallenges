package com.api.amedigital.starwars.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Planeta {

	@Id
	String name;
	String diameter;
	String rotation_period;
	String orbital_period;
	String gravity;
	String population;
	String climate;
	String terrain;
	String surface_water;
	String url;
	
	@ElementCollection(targetClass=String.class)
	List<String> films = new ArrayList<String>();
	
	@ElementCollection(targetClass=String.class)
	List<String> residents = new ArrayList<String>();
	
}
