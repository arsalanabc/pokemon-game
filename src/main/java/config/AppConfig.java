package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import service.PokemonService;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${serverUrl}")
    String pokemonServerUrl;

    @Bean
    public PokemonService pokemonService() {
        System.out.println("pokemonServerUrl"+pokemonServerUrl);
        return new PokemonService(pokemonServerUrl);
    }

}
