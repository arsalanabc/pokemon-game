package pokemongame.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pokemongame.service.PokemonServer;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${serverUrl}")
    String pokemonServerUrl;

    @Bean(name = "pokemonService")
    public PokemonServer pokemonService() {
        System.out.println("pokemonServerUrl"+pokemonServerUrl);
        return new PokemonServer(pokemonServerUrl);
    }

}
