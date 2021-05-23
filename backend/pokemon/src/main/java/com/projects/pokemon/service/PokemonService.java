package com.projects.pokemon.service;

import com.projects.pokemon.mappers.PokeApiMapper;
import com.projects.pokemon.model.PokemonCardInfo;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import com.projects.pokemon.model.pokeApiService.response.models.PokeApiPokemonShortInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    @Autowired
    private PokeApi externalPokeApi;

    public List<PokemonCardInfo> fetchCards(Integer startPoint, Integer packageSize) throws IOException {

        PokemonCardInfo cardInfo = new PokemonCardInfo();
        cardInfo.setPokeId(1);

        ArrayList arrayList = new ArrayList();
        arrayList.add(cardInfo);

        Response<PokeApiPokemonResponse> responseCall = externalPokeApi.getPokemon(startPoint,packageSize).execute();

        if (!responseCall.isSuccessful()){
            // ERROR !
            return null;
        }

        System.out.println(responseCall.body());

        return responseCall.body()
                    .getResults()
                    .stream()
                        .map(pokeApiPokemonShortInfoResponse -> fetchPokemonFullInfo(pokeApiPokemonShortInfoResponse))
                        .map(PokeApiMapper::pokeApiFullToPokemonCard)
                        .collect(Collectors.toList());
    }

    public PokeApiPokemonFullInfoResponse fetchPokemonFullInfo (PokeApiPokemonShortInfoResponse pokeApiPokemonShortInfoResponse) {
        try {
            return fetchPokemonFullInfoFromPokeApi(pokeApiPokemonShortInfoResponse.getName());
        } catch (Exception e) {
            // Ups
            return null;
        }
    }

    private PokeApiPokemonFullInfoResponse fetchPokemonFullInfoFromPokeApi (String pokeName) throws IOException {
        Response<PokeApiPokemonFullInfoResponse> response =
                externalPokeApi.getPokemonByName(pokeName).execute();
        if (!response.isSuccessful()){
            // ERROR !
            return null;
        }
        return response.body();
    }

}
