package com.projects.pokemon.commands;

import com.projects.pokemon.commands.receivers.FetchPokemonSpecieReceiver;
import com.projects.pokemon.exception.PokeApiIOException;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonSpecies;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class FetchPokemonSpecieCommand implements ICommand<PokeApiPokemonSpecies> {

    @NonNull
    private Integer id;

    @NonNull
    private FetchPokemonSpecieReceiver receiver;

    private PokeApiPokemonSpecies response;

    @Override
    public FetchPokemonSpecieCommand execute() {
        log.info(String.format("Executing FetchPokemonSpecieCommand with id -> %s", id));
        try {
            this.response =  receiver.fetchPokemonSpecieFromPoke(id);
        } catch (IOException e) {
            throw new PokeApiIOException(e.getMessage());
        }

        return this;
    }

    @Override
    public PokeApiPokemonSpecies getResult() {
        return response;
    }
}
