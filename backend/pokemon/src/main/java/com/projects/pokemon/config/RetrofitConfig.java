package com.projects.pokemon.config;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.pokemon.service.PokeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${pokeApi.url}")
    private String pokeApiUrl;

    @Bean
    public PokeApi externalPokeApi(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(pokeApiUrl)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper()))
                .build();

        return retrofit.create(PokeApi.class);
    }

    private ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

}
