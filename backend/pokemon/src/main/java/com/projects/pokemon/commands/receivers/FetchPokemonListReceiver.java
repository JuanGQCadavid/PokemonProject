package com.projects.pokemon.commands.receivers;

import com.projects.pokemon.exception.PokeApiNotSuccessfulResponseException;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import com.projects.pokemon.service.PokeApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;


@Slf4j
@Component
public class FetchPokemonListReceiver {

    @Autowired
    PokeApi externalPokeApi;

    public PokeApiPokemonResponse fetchPokemonListFromPokeApi (Integer startPoint, Integer packageSize) throws IOException {
        log.info(String.format("Fetching pokemon list from PokeApi, params ->  Start point %s, Package size %s",
                startPoint, packageSize));

        Response<PokeApiPokemonResponse> response =
                externalPokeApi.getPokemon(startPoint,packageSize).execute();

        if (!response.isSuccessful()){
            throw new PokeApiNotSuccessfulResponseException(response.errorBody().string());
        }
        return response.body();
    }
}
