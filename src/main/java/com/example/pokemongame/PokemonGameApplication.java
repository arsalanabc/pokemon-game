package com.example.pokemongame;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Game;
import model.Player;
import model.Pokemon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import javax.crypto.spec.PSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PokemonGameApplication {

	public static void main(String[] args) throws JsonProcessingException {

		List<Pokemon> pokemons = new ArrayList<>();

		System.out.println("this is a test");
		RestTemplate restTemplate = new RestTemplate();
		for (int i = 1; i <= 5; i++) {
			String result = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+ i, String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			Pokemon pokemon = objectMapper.readValue(result, Pokemon.class);
			pokemons.add(pokemon);
		}
		Game game = new Game(pokemons);
		game.showPokemons().forEach(System.out::println);
		game.setPlayerOne(new Player("player_1", pokemons.get(0)));
		game.setPlayerTwo(new Player("player_2", pokemons.get(1)));

		game.startBattle();
		Player player = game.getWinner();
		System.out.println(player);


		SpringApplication.run(PokemonGameApplication.class, args);
	}

}
