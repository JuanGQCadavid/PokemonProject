package com.projects.pokemon.model.pokeApiService.response.models;

import lombok.Data;

import java.util.List;

@Data
public class PokeApiChain {
    private List<PokeApiEvolutionDetails> evolution_details;
    private List<PokeApiChain> evolves_to;
    private PokeApiOnlyName species;
}
