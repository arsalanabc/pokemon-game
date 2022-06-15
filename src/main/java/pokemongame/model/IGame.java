package pokemongame.model;

import java.util.List;

public interface IGame {
    void setPlayerOne(Player playerOne);
    void setPlayerTwo(Player playerTwo);
    void startBattle();
    Player getWinner();
    List<Pokemon> getPokemons();
}
