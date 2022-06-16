package pokemongame.model;

import java.util.Objects;

public class Player {
    public String name;
    private Pokemon pokemon;

    public Player(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    void revive(){
        this.pokemon.revive();
    }

    public String getName() {
        return this.name;
    }
    public Pokemon getPokemon() {
        return this.pokemon;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pokemon=" + pokemon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(pokemon, player.pokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pokemon);
    }
}
