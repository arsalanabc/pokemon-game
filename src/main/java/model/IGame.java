package model;

import java.util.List;

public interface IGame {
    void setPlayerOne();
    void setPlayerTwo();
    void startGame();
    Player getWinner();
    List<Pokemon> showPokemons();
}
