package pokemongame.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pokemongame.model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class PokemonServer {
    String serverUrl;
    List<Pokemon> pokemons;
    int POKEMON_COUNT = 5;

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public PokemonServer(String serverUrl){
        this.serverUrl = serverUrl;
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> fetchPokemons() {

        this.pokemons.clear();

        RestTemplate restTemplate = new RestTemplate();
        for (int i = 1; i <= POKEMON_COUNT; i++) {
            String result = restTemplate.getForObject(this.serverUrl + i, String.class);

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Pokemon pokemon = objectMapper.readValue(result, Pokemon.class);
                this.pokemons.add(pokemon);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return this.pokemons;
    }
}
