package model;

import java.util.Objects;

public class Player {
    public String name;
    public Pokemon pokemon;
    public int health = 10;
    private boolean isDeath = false;

    public Player(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    void damage(int damage){
        this.health -= damage;
        if(this.health < 0){
            this.isDeath = true;
        }
    }

    public boolean isDead(){
        return this.isDeath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return health == player.health &&
                isDeath == player.isDeath &&
                Objects.equals(name, player.name) &&
                Objects.equals(pokemon, player.pokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pokemon, health, isDeath);
    }

    @Override
    public String toString() {
        return "Player{" +
                "pokemon=" + pokemon +
                ", health=" + health +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return this.name;
    }
}
