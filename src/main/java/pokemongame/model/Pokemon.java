package pokemongame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private static final int DEFAULT_HEALTH = 20;

    @JsonProperty("name")
    public String name;

    @JsonProperty("weight")
    public String weight;

    @JsonProperty("height")
    public String height;

    private int health = DEFAULT_HEALTH;


    public Pokemon() {
    }

    void revive(){
        this.health = DEFAULT_HEALTH;
    }

    public void damage(int damage){
        this.health -= damage;
    }

    public boolean isDead(){
        return this.health <= 0;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                '}';
    }

    public Pokemon(String name, String weight, String height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }
}
