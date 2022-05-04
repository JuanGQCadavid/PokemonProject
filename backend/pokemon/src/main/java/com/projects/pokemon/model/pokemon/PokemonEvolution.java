package com.projects.pokemon.model.pokemon;

import com.projects.pokemon.model.pokeApiService.response.models.PokeApiChain;
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

    public static PokemonEvolution fromApi(PokeApiChain chain) {
        if (chain == null) {
            return null;
        }

        return PokemonEvolution.builder()
                .levelToEvolved( chain.getEvolution_details() != null &&  chain.getEvolution_details().size() > 0
                        ? chain.getEvolution_details().get(0).getMin_level()
                        : 0)
                .name(chain.getSpecies().getName())
                .nextEvolution( chain.getEvolves_to() != null &&  chain.getEvolves_to().size() > 0
                        ? PokemonEvolution.fromApi(chain.getEvolves_to().get(0))
                        : null)
                .build();
    }
}
