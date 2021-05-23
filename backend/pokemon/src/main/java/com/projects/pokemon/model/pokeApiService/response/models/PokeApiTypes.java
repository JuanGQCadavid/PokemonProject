package com.projects.pokemon.model.pokeApiService.response.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeApiTypes {
    private Integer slot;
    private PokeApiType type;

}
