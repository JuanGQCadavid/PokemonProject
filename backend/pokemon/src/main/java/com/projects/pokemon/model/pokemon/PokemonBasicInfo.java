package com.projects.pokemon.model.pokemon;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonBasicInfo {

    private String name;
    private List<String> types;
    private Integer weight;
    private List<PokemonAbility> abilities;


    public static PokemonBasicInfo fromPokeApi(PokeApiPokemonFullInfoResponse pokeApiPokemonFullInfoResponse) {
        return PokemonBasicInfo.builder()
                .name(pokeApiPokemonFullInfoResponse.getName())
                .types(
                        pokeApiPokemonFullInfoResponse.getTypes().stream()
                            .map(pokeApiTypes -> pokeApiTypes.getType().getName())
                            .collect(Collectors.toList())
                )
                .abilities(
                        pokeApiPokemonFullInfoResponse.getAbilities().stream()
                            .map(pokeAbility -> PokemonAbility.fromPokeApiAbility(pokeAbility))
                            .collect(Collectors.toList())
                )
                .weight(pokeApiPokemonFullInfoResponse.getWeight())
                .build();
    }
}
