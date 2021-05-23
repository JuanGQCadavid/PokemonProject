package com.projects.pokemon.model;

import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokemon.PokemonBasicInfo;
import com.projects.pokemon.model.pokemon.PokemonMedia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonCardInfo {
    private Integer pokeId;
    private PokemonBasicInfo pokemonBasicInfo;
    private PokemonMedia pokemonMedia;



}
