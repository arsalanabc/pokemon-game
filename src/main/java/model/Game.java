package model;

import java.util.*;

public class Game implements IGame {
    private static final int GAME_ROUNDS = 3;
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
        if(players[0] == null || players[1]  == null) {
            throw new NullPointerException("one or both players are missing");
        }
        Set<Player> winnerList = new HashSet<>();

        Player currentPlayer = players[0];

        for (int i = 1; i < GAME_ROUNDS+1; i++) {
            if(winnerList.contains(this.winner)){break;}
            System.out.println("ROUND - "+i);
            Arrays.stream(players).forEach(Player::revive);

            while(true){
                int damage = (int) Math.max(1, Math.round(Math.random()*10) % 10 );
                currentPlayer.damage(damage);
                if(currentPlayer.isDead()) break;
                currentPlayer = currentPlayer == players[0]? players[1]: players[0];
                winnerList.add(currentPlayer);
            }
            this.winner = players[0].isDead()? players[1]: players[0];
            winnerList.add(this.winner);
            System.out.println("The winner is "+this.winner.getName());
        }

    }

    @Override
    public Player getWinner() {
        if(this.winner  == null) {
            throw new NullPointerException("Winning player is missing!");
        }
        return this.winner;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

}
