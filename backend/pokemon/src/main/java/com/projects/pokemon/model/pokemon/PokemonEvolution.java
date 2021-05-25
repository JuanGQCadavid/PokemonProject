package com.projects.pokemon.model.pokemon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonEvolution {
    private String name;
    private Integer levelToEvolved;
    private PokemonEvolution nextEvolution;
}
