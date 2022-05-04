package com.projects.pokemon.commands.receivers;

import com.projects.pokemon.exception.PokeApiNotFoundException;
import com.projects.pokemon.exception.PokeApiNotSuccessfulResponseException;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.service.PokeApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;

@Component
@Slf4j
public class FetchPokemonFullInfoReceiver {
    @Autowired
    PokeApi externalPokeApi;

    public PokeApiPokemonFullInfoResponse fetchPokemonFullInfoFromPokeApi (String pokeName) throws IOException {
        log.info(String.format("fetchPokemonFullInfoFromPokeApi with pokeName -> %s", pokeName));

        Response<PokeApiPokemonFullInfoResponse> response =
                externalPokeApi.getPokemonByName(pokeName).execute();
        if (!response.isSuccessful()){
            log.error(String.valueOf(response.code()));
            if (response.code() == HttpStatus.NOT_FOUND.value())
                throw new PokeApiNotFoundException(pokeName);

            throw new PokeApiNotSuccessfulResponseException(response.errorBody().string());
        }
        return response.body();
    }


}
