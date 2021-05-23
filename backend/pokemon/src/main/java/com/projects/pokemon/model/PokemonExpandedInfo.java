package com.projects.pokemon.model;

import com.projects.pokemon.model.pokemon.PokemonBasicInfo;
import com.projects.pokemon.model.pokemon.PokemonEvolutions;
import com.projects.pokemon.model.pokemon.PokemonMedia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonExpandedInfo {
    private Integer pokeId;
    private String description;
    private PokemonBasicInfo pokemonBasicInfo;
    private PokemonMedia pokemonMedia;
    private PokemonEvolutions pokemonEvolutions;
}
