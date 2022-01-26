package com.api.amedigital.starwars.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Planet {

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
	String created;
	List<String> films = new ArrayList<String>();
	List<String> residents = new ArrayList<String>();
	
}
