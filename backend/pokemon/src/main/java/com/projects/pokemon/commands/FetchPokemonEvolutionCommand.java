package com.projects.pokemon.commands;

import com.projects.pokemon.commands.receivers.FetchPokemonEvolutionReceiver;
import com.projects.pokemon.exception.PokeApiIOException;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonEvolutionChain;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonSpecies;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class FetchPokemonEvolutionCommand implements ICommand<PokeApiPokemonEvolutionChain> {

    @NonNull
    private Integer evolutionChainId;

    @NonNull
    private FetchPokemonEvolutionReceiver receiver;

    private PokeApiPokemonEvolutionChain response;

    @Override
    public FetchPokemonEvolutionCommand execute() {
        log.info(String.format("Executing FetchPokemonEvolutionCommand with evolutionChainId -> %s", evolutionChainId));
        try {
            this.response =  receiver.fetchPokemonEvolutionFromPoke(evolutionChainId);
        } catch (IOException e) {
            throw new PokeApiIOException(e.getMessage());
        }

        return this;
    }

    @Override
    public PokeApiPokemonEvolutionChain getResult() {
        return response;
    }
}
