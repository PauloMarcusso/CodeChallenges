package com.challenge.petlove.animal;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.petlove.model.Animal;
import com.challenge.petlove.repository.AnimalRepository;
import com.challenge.petlove.service.AnimalService;

@ExtendWith(MockitoExtension.class)
class AnimalTest {

	@InjectMocks
	private AnimalService animalService;
	
	@Mock
	private AnimalRepository animalRepository;
	
//	@Test
//	void deveRetornarCustoMedioPorTipo() {
//		List<Animal> animais = new ArrayList<>();
//		Animal animal1 = new Animal("adasd", new BigDecimal("100"), "Cachorro");
//		Animal animal2 = new Animal("adsdasd", new BigDecimal("200"), "Cachorro");
//		
//		animais.add(animal1);
//		animais.add(animal2);
//		
//		when(animalRepository.findByTipo("Cachorro")).thenReturn(animais);
//		
//		BigDecimal custoMedio = animalService.calcularCustoMedio("Cachorro");
//		Assertions.assertEquals(new BigDecimal("99.99"), custoMedio);
//		
//	}

}
