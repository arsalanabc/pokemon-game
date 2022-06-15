package pokemongame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pokemongame.service.GameHandler;

@SpringBootApplication
public class PokemonGameApplication implements CommandLineRunner {

	public static void main(String[] args) {
		 SpringApplication.run(PokemonGameApplication.class, args);
	}

	@Autowired
	GameHandler gameHandler;

	@Override
	public void run(String ... args) throws Exception{
		gameHandler.StartGame();

	}


}
