package com.projects.pokemon.model.pokemon;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonMedia {
    private String defaultPicture;
    private String dreamWordPicture;

    public static PokemonMedia fromPokeApi(PokeApiPokemonFullInfoResponse pokeApiPokemonFullInfoResponse) {
        return PokemonMedia.builder()
                .dreamWordPicture(pokeApiPokemonFullInfoResponse.getSprites().getOther().getDream_world().getFront_default())
                .defaultPicture(pokeApiPokemonFullInfoResponse.getSprites().getFront_default())
                .build();
    }
}
