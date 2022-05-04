package com.projects.pokemon.model.pokemon;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonEvolutionChain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonEvolutions {
    private PokemonEvolution pokemonEvolution;
    private Integer pokeEvolutionId;

    public static PokemonEvolutions fromPokeApi(PokeApiPokemonEvolutionChain evolutionChain) {
        return PokemonEvolutions.builder()
                .pokeEvolutionId(evolutionChain.getId())
                .pokemonEvolution(PokemonEvolution.fromApi(evolutionChain.getChain()))
                .build();
    }
}
