package com.projects.pokemon.mappers;

import com.projects.pokemon.model.PokemonCardInfo;
import com.projects.pokemon.model.PokemonExpandedInfo;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonEvolutionChain;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonSpecies;
import com.projects.pokemon.model.pokemon.PokemonBasicInfo;
import com.projects.pokemon.model.pokemon.PokemonDescription;
import com.projects.pokemon.model.pokemon.PokemonEvolutions;
import com.projects.pokemon.model.pokemon.PokemonMedia;

public class PokeApiMapper {

    public static PokemonCardInfo pokeApiFullToPokemonCard (PokeApiPokemonFullInfoResponse pokeApiPokemonFullInfoResponse){
        return PokemonCardInfo.builder()
                .pokeId(pokeApiPokemonFullInfoResponse.getId())
                .pokemonMedia( PokemonMedia.fromPokeApi(pokeApiPokemonFullInfoResponse))
                .pokemonBasicInfo( PokemonBasicInfo.fromPokeApi(pokeApiPokemonFullInfoResponse))
                .build();
    }

    public static PokemonExpandedInfo pokeApiFullToPokemonExpandedInfo(PokeApiPokemonFullInfoResponse pokeApiPokemonFullInfoResponse,
                                                                       PokeApiPokemonSpecies species,
                                                                       PokeApiPokemonEvolutionChain evolutionChain) {
        return PokemonExpandedInfo.builder()
                .pokemonMedia( PokemonMedia.fromPokeApi(pokeApiPokemonFullInfoResponse) )
                .pokeId(pokeApiPokemonFullInfoResponse.getId())
                .pokemonBasicInfo( PokemonBasicInfo.fromPokeApi(pokeApiPokemonFullInfoResponse))
                .description(PokemonDescription.pokemonDescriptionFromPokeAPI(pokeApiPokemonFullInfoResponse,species))
                .pokemonEvolutions(PokemonEvolutions.fromPokeApi(evolutionChain))
                .build();
    }

}
