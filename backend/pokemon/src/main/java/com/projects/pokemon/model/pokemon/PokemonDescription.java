package com.projects.pokemon.model.pokemon;

import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonSpecies;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonDescription {
    private List<PokemonStat> stats;
    private String habitat;
    private String shape;

    public static PokemonDescription pokemonDescriptionFromPokeAPI(PokeApiPokemonFullInfoResponse fullInfoResponse,
                                                                   PokeApiPokemonSpecies species){
        return PokemonDescription.builder()
                .stats(
                        fullInfoResponse.getStats().stream()
                                .map(pokeApiStats -> PokemonStat.builder()
                                        .name(pokeApiStats.getStat().getName())
                                        .value(pokeApiStats.getBase_stat())
                                        .build()
                                )
                                .collect(Collectors.toList())
                )
                .habitat( species.getHabitat().getName())
                .shape( species.getShape().getName() )
                .build();

    }
}
