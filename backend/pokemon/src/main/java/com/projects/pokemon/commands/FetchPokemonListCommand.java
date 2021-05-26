package com.projects.pokemon.commands;

import com.projects.pokemon.commands.receivers.FetchPokemonListReceiver;
import com.projects.pokemon.exception.PokeApiIOException;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class FetchPokemonListCommand implements  ICommand<PokeApiPokemonResponse>{

    @NonNull
    private Integer startPoint;

    @NonNull
    private Integer packageSize;

    @NonNull
    private FetchPokemonListReceiver receiver;

    private PokeApiPokemonResponse response;

    @Override
    public FetchPokemonListCommand execute() {
        log.info(String.format("Executing FetchPokemonListCommand with startPoint -> %s, packageSize -> %s", startPoint,packageSize));
        try {
            this.response =  receiver.fetchPokemonListFromPokeApi(startPoint,packageSize);
        } catch (IOException e) {
            throw new PokeApiIOException(e.getMessage());
        }
        return this;
    }

    @Override
    public PokeApiPokemonResponse getResult() {
        return response;
    }
}
