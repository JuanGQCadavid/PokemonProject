package com.projects.pokemon.commands.receivers;

import com.projects.pokemon.exception.PokeApiNotSuccessfulResponseException;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonEvolutionChain;
import com.projects.pokemon.service.PokeApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;


@Slf4j
@Component
public class FetchPokemonEvolutionReceiver {

    @Autowired
    PokeApi externalPokeApi;

    public PokeApiPokemonEvolutionChain fetchPokemonEvolutionFromPoke (Integer evolutionChainId) throws IOException {
        log.info(String.format("fetchPokemonEvolutionFromPoke, params ->  evolutionChainId %s",
                evolutionChainId));

        Response<PokeApiPokemonEvolutionChain> response =
                externalPokeApi.getPokemonEvolution(evolutionChainId).execute();

        if (!response.isSuccessful()){
            throw new PokeApiNotSuccessfulResponseException(response.errorBody().string());
        }
        return response.body();
    }
}
