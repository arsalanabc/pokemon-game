package com.example.pokemongame;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Pokemon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import javax.crypto.spec.PSource;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class PokemonGameApplication {

	public static void main(String[] args) throws JsonProcessingException {

		System.out.println("this is a test");
		String url = "https://pokeapi.co/api/v2/pokemon/2";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		Pokemon pokemon = objectMapper.readValue(result, Pokemon.class);
		System.out.println(pokemon);

		SpringApplication.run(PokemonGameApplication.class, args);
	}

}
