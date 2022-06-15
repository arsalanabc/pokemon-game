package pokemongame.service;

import org.springframework.beans.factory.annotation.Autowired;
import pokemongame.config.AppConfig;
import pokemongame.model.Game;
import pokemongame.model.Player;
import pokemongame.model.Pokemon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class GameHandler {

    @Autowired
    PokemonServer pokemonService;
    public void StartGame(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        PokemonService pokemonService = (PokemonService) context.getBean("pokemonService");
//
        List<Pokemon> pokemons = pokemonService.fetchPokemons();

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
                        while(true){
                            showPokemons(game);
                            int i = scanner.nextInt();
                            if(i < 0 || i >= game.getPokemons().size()) {
                                System.out.println("Invalid Pokemon. Please pick again!");
                            } else {
                                Pokemon p = game.getPokemons().get(i);
                                Player player1 = new Player("player_1", p);
                                game.setPlayerOne(player1);
                                System.out.println(p.getName()+" is picked for "+player1.getName());
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Pick a Pokemon for player two!");
                        while(true){
                            showPokemons(game);
                            int i = scanner.nextInt();
                            if(i < 0 || i >= game.getPokemons().size()) {
                                System.out.println("Invalid Pokemon. Please pick again!");
                            } else {
                                Pokemon p = game.getPokemons().get(i);
                                Player player = new Player("player_2", p);
                                game.setPlayerTwo(player);
                                System.out.println(p.getName()+" is picked for "+player.getName());
                                break;
                            }
                        }
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

}
