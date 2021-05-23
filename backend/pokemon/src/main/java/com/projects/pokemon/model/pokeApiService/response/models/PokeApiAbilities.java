package com.projects.pokemon.model.pokeApiService.response.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeApiAbilities {
    private PokeApiAbility ability;
    private Boolean is_hidden;
    private Integer slot;
}
