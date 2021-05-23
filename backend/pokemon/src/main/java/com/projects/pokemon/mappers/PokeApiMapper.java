package com.projects.pokemon.mappers;

import com.projects.pokemon.model.PokemonCardInfo;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokemon.PokemonBasicInfo;
import com.projects.pokemon.model.pokemon.PokemonMedia;

public class PokeApiMapper {

    public static PokemonCardInfo pokeApiFullToPokemonCard (PokeApiPokemonFullInfoResponse pokeApiPokemonFullInfoResponse){
        return PokemonCardInfo.builder()
                .pokeId(pokeApiPokemonFullInfoResponse.getId())
                .pokemonMedia( PokemonMedia.fromPokeApi(pokeApiPokemonFullInfoResponse))
                .pokemonBasicInfo( PokemonBasicInfo.fromPokeApi(pokeApiPokemonFullInfoResponse))
                .build();
    }

}
