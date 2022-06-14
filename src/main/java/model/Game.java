package model;

import java.util.List;
import java.util.Random;

public class Game implements IGame {
    public List<Pokemon> pokemons;
    Player[] players = new Player[2];
    Player winner;

    public Game(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public void setPlayerOne(Player player) {
        this.players[0] = player;
    }

    @Override
    public void setPlayerTwo(Player player) {
        this.players[1] = player;
    }

    @Override
    public void startBattle() {
        Player current = players[0];
        while(true){
            int damage = (int) Math.max(1, Math.round(Math.random()*10) % 10 );
            current.damage(damage);
            if(current.isDead()) break;
            current = current == players[0]? players[1]: players[0];
        }
        this.winner = players[0].isDead()? players[1]: players[0];;
    }

    @Override
    public Player getWinner() {
        return this.winner;
    }

    @Override
    public List<Pokemon> showPokemons() {
        return this.pokemons;
    }

}
