package pokemongame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import pokemongame.model.Game;
import pokemongame.model.Player;
import pokemongame.model.Pokemon;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class GameHandler {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    PokemonServer pokemonService;

    public void StartGame(){
        List<Pokemon> pokemons = pokemonService.getPokemons();

        Game game = new Game(pokemons);
        showMenu();

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Pick an option! 7 to show menu");
            try {
                int userInput = scanner.nextInt();

                if(userInput == 0) break;

                switch (userInput){
                    case 1:
                        showPokemons(game);
                        break;
                    case 2:
                        System.out.println("Pick a Pokemon for player one!");
                        setAPlayer(game, scanner, "player-1", 1);
                        break;
                    case 3:
                        System.out.println("Pick a Pokemon for player two!");
                        setAPlayer(game, scanner, "player-2", 2);
                        break;
                    case 4:
                        try {
                            game.startBattle();
                            System.out.println("Battle is over");
                        } catch (NullPointerException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("The winner is "+ game.getWinner().getName());
                        } catch (NullPointerException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        game = new Game(pokemons);
                        break;
                    case 7:
                        showMenu();
                        break;
                    default:
                        System.out.println("Invalid entry");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid entry");
            }
        }
        exitGame(0);
    }

    private void setAPlayer(Game game, Scanner scanner, String playerName, int playerNumber) {
        while(true){
            showPokemons(game);
            int i = scanner.nextInt();
            if(i < 0 || i >= game.getPokemons().size()) {
                System.out.println("Invalid Pokemon. Please pick again!");
            } else {
                Pokemon p = game.getPokemons().get(i);
                Player player = new Player(playerName, p);
                if (playerNumber == 1) {
                    game.setPlayerOne(player);
                } else {
                    game.setPlayerTwo(player);
                }
                System.out.println(p.getName()+" is picked for "+player.getName());
                break;
            }
        }
    }


    private void showMenu() {
        List<String> options = new ArrayList<>();
        options.add("1: Show list of Pokemons.");
        options.add("2: Pick a pokemon for Player One.");
        options.add("3: Pick a pokemon for Player Two.");
        options.add("4: Start a battle.");
        options.add("5: Show the winner.");
        options.add("6: New Game.");
        options.add("7: Show Menu.");
        options.add("0: Exit.");

        options.forEach(System.out::println);
        System.out.println("\n");
    }

    private void showPokemons(Game game) {
        List<Pokemon> listOfPokemons = game.getPokemons();
        for (int i = 0; i < listOfPokemons.size(); i++) {
            Pokemon pokemon = listOfPokemons.get(i);
            System.out.println("ID: "+i+", Name: "+pokemon.getName()+", Height: "+pokemon.getName()+", Weight: "+pokemon.getName());
        }
        System.out.println("\n");
    }

    public void exitGame(int returnCode){
        SpringApplication.exit(applicationContext, () -> returnCode);
    }
}
