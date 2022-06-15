package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Pokemon;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    String serverUrl;
    List<Pokemon> pokemons;
    int POKEMON_COUNT = 5;

    public PokemonService(String serverUrl){
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
