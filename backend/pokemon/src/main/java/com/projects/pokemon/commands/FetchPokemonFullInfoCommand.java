package com.projects.pokemon.commands;

import com.projects.pokemon.commands.receivers.FetchPokemonFullInfoReceiver;
import com.projects.pokemon.exception.PokeApiIOException;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class FetchPokemonFullInfoCommand implements ICommand<PokeApiPokemonFullInfoResponse> {

    @NonNull
    private String pokeName;

    @NonNull
    private FetchPokemonFullInfoReceiver receiver;

    private PokeApiPokemonFullInfoResponse response;

    @Override
    public FetchPokemonFullInfoCommand execute() {
        log.info(String.format("Executing fetchPokemonFullInfoCommand with pokeName -> %s", pokeName));
        try {
            this.response =  receiver.fetchPokemonFullInfoFromPokeApi(pokeName);
        } catch (IOException e) {
            throw new PokeApiIOException(e.getMessage());
        }

        return this;
    }

    @Override
    public PokeApiPokemonFullInfoResponse getResult() {
        return response;
    }
}
