package com.projects.pokemon.model.pokeApiService.response;

import com.projects.pokemon.model.pokeApiService.response.models.PokeApiAbilities;
import com.projects.pokemon.model.pokeApiService.response.models.PokeApiSprites;
import com.projects.pokemon.model.pokeApiService.response.models.PokeApiStats;
import com.projects.pokemon.model.pokeApiService.response.models.PokeApiTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeApiPokemonFullInfoResponse {
    private List<PokeApiAbilities> abilities;
    private Integer base_experience;
    private Integer weight;
    private String name;
    private Integer id;
    private PokeApiSprites sprites;
    private List<PokeApiStats> stats; // Good for description.
    private List<PokeApiTypes> types; // Good for description.
}


