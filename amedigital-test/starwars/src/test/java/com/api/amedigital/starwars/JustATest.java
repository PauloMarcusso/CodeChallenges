package com.api.amedigital.starwars;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.amedigital.starwars.model.Planet;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class JustATest {
	
	@Autowired
	ObjectMapper objectMapper = new ObjectMapper();
	
	String BASE_URL = "https://swapi.dev/api/";
	HttpClient client;
	
	@BeforeEach
	public void setup() {
		client = HttpClient.newBuilder().build();
	}

	@Test
	void shouldRetriveDataFromStarwarsAPI() throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + "planets/1/")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Planet planet = objectMapper.readValue(response.body(), Planet.class);
		
		System.out.println(planet);
		Assertions.assertEquals("Tatooine", planet.getName());
	    
	}
	

	
}
