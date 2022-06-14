package com.example.pokemongame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonGameApplication {

	public static void main(String[] args) {

		System.out.println("this is a test");
		SpringApplication.run(PokemonGameApplication.class, args);
	}

}
