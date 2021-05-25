package com.projects.pokemon.model.pokeApiService.response;

import com.projects.pokemon.model.pokeApiService.response.models.PokeApiChain;
import lombok.Data;

@Data
public class PokeApiPokemonEvolutionChain {
    private PokeApiChain chain;
    private Integer id;
}
