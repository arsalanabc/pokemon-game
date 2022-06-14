package model;


import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    private List<Pokemon> pokemons;
    Player[] players = new Player[2];
    Player winner;

    public Game() {
        this.players = new Player[2];
        this.pokemons = new ArrayList<Pokemon>();
    }

    @Override
    public void setPlayerOne() {

    }

    @Override
    public void setPlayerTwo() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public List<Pokemon> showPokemons() {
        return this.pokemons;
    }

}
