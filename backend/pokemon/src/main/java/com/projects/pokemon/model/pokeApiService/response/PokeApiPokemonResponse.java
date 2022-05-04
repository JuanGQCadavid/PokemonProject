package com.projects.pokemon.model.pokeApiService.response;

import com.projects.pokemon.model.pokeApiService.response.models.PokeApiPokemonShortInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeApiPokemonResponse {

    private Integer count;
    private List<PokeApiPokemonShortInfoResponse> results;
}
