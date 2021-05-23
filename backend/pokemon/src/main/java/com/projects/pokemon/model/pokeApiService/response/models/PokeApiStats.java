package com.projects.pokemon.model.pokeApiService.response.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokeApiStats {
    private Integer base_stat;
    private Integer effort;
    private PokeApiStat stat;

}
