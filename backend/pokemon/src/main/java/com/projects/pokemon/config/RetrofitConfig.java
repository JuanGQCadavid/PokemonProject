package com.projects.pokemon.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetrofitConfig {

    @Value("${pokeApi.url}")
    private String pokeApiUrl;

}
