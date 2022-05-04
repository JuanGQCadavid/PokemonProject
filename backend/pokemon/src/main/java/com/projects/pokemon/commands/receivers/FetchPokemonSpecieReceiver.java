package com.projects.pokemon.commands.receivers;

import com.projects.pokemon.exception.PokeApiNotSuccessfulResponseException;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonSpecies;
import com.projects.pokemon.service.PokeApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;


@Slf4j
@Component
public class FetchPokemonSpecieReceiver {

    @Autowired
    PokeApi externalPokeApi;

    public PokeApiPokemonSpecies fetchPokemonSpecieFromPoke (Integer id) throws IOException {
        log.info(String.format("fetchPokemonSpecieFromPoke, params ->  id %s",
                id));

        Response<PokeApiPokemonSpecies> response =
                externalPokeApi.getPokemonSpecie(id).execute();

        if (!response.isSuccessful()){
            throw new PokeApiNotSuccessfulResponseException(response.errorBody().string());
        }
        return response.body();
    }
}
