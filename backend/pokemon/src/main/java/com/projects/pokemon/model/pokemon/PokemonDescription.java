package com.projects.pokemon.model.pokemon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonDescription {
    private List<PokemonStat> stats;
    private String habitat;
    private String shape;
}
