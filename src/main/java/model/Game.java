package model;


import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    public List<Pokemon> pokemons;
    Player[] players = new Player[2];
    Player winner;

    public Game(List<Pokemon> pokemons) {
        this.players = new Player[2];
        this.pokemons = pokemons;
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
