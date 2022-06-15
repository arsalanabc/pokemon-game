package pokemongame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pokemongame.service.GameHandler;
import pokemongame.service.PokemonServer;

@SpringBootApplication
public class PokemonGameApplication implements CommandLineRunner {

	public static void main(String[] args) {
		 SpringApplication.run(PokemonGameApplication.class, args);
	}

	@Autowired
	GameHandler gameHandler;

	@Autowired
	PokemonServer pokemonServer;

	@Override
	public void run(String ... args) throws Exception{
		pokemonServer.fetchPokemons();
		gameHandler.StartGame();
	}


}
