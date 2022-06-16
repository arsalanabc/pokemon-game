package pokemongame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pokemongame.model.Game;
import pokemongame.model.Player;
import pokemongame.model.Pokemon;
import pokemongame.service.PokemonServer;

import java.util.ArrayList;
import java.util.List;


class PokemonGameApplicationTests {

	static String name = "https://pokeapi.co/api/v2/pokemon/";
	static PokemonServer pokemonServer = new PokemonServer(name);

	@BeforeAll
	static void before(){
		pokemonServer = new PokemonServer(name);
	}
	@Test
	void shouldKillPlayer() {

		Player player = new Player("test", new Pokemon());
		assert player.getPokemon().isDead() == false;
		player.getPokemon().damage(100);
		assert player.getPokemon().isDead() == true;
	}

	@Test
	void shouldFetchPokemonFromServer() {

		pokemonServer.fetchPokemons();
		assert pokemonServer.getPokemons().size() > 0;
	}

	@Test
	void shouldPlayGame() {
		Game game = new Game(pokemonServer.getPokemons());
		List<Player> players = new ArrayList<>();
		players.add(new Player("test1", new Pokemon()));
		players.add(new Player("test2", new Pokemon()));
		game.setPlayerOne(players.get(0));
		game.setPlayerTwo(players.get(1));

		game.startBattle();
		assert players.contains(game.getWinner());
	}

}
