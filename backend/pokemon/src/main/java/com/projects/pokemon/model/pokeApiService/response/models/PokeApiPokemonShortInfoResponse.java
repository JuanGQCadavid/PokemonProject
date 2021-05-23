package com.projects.pokemon.model.pokeApiService.response.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeApiPokemonShortInfoResponse {
    private String name;
    private String url;
}
