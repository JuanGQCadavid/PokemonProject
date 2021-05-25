package com.projects.pokemon.model.pokeApiService.response;

import com.projects.pokemon.model.pokeApiService.response.models.PokeApiOnlyName;
import com.projects.pokemon.model.pokeApiService.response.models.PokeApiOnlyURL;
import lombok.Data;

@Data
public class PokeApiPokemonSpecies {
    private PokeApiOnlyName habitat;
    private PokeApiOnlyName shape;
    private PokeApiOnlyURL evolution_chain;
}
