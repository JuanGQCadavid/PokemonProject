package com.projects.pokemon.model.pokemon;

import com.projects.pokemon.model.pokeApiService.response.models.PokeApiAbilities;
import com.projects.pokemon.model.pokeApiService.response.models.PokeApiAbility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonAbility {
    private String name;
    private Integer slot;
    private Boolean is_hidden;

    public static PokemonAbility fromPokeApiAbility(PokeApiAbilities pokeApiAbilities) {
            return PokemonAbility.builder()
                    .is_hidden(pokeApiAbilities.getIs_hidden())
                    .name(pokeApiAbilities.getAbility().getName())
                    .slot(pokeApiAbilities.getSlot())
                    .build();
    }

}
