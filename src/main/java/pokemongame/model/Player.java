package pokemongame.model;

import java.util.Objects;

public class Player {
    private static final int DEFAULT_HEALTH = 20;
    public String name;
    public Pokemon pokemon;
    public int health = DEFAULT_HEALTH;

    public Player(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    void damage(int damage){
        this.health -= damage;
    }

    void revive(){
        this.health = DEFAULT_HEALTH;
    }

    public boolean isDead(){
        return this.health <= 0;
    }

   public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return health == player.health && Objects.equals(name, player.name) && Objects.equals(pokemon, player.pokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pokemon, health);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pokemon=" + pokemon +
                ", health=" + health +
                '}';
    }
}
