package com.api.amedigital.starwars;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.amedigital.starwars.model.Planet;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class JustATest {
	
	@Autowired
	ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void shouldRetriveDataFromStarwarsAPI() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://swapi.dev/api/planets/1/")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Planet planet = objectMapper.readValue(response.body(), Planet.class);
		
		System.out.println(planet);
		Assertions.assertEquals("Tatooine", planet.getName());
	    
	}
}
