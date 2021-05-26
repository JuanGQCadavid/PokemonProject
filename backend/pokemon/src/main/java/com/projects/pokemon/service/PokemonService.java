package com.projects.pokemon.service;

import com.projects.pokemon.exception.PokeApiIOException;
import com.projects.pokemon.exception.PokeApiNotFoundException;
import com.projects.pokemon.exception.PokeApiNotSuccessfulResponseException;
import com.projects.pokemon.mappers.PokeApiMapper;
import com.projects.pokemon.model.PokemonCardInfo;
import com.projects.pokemon.model.PokemonExpandedInfo;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonEvolutionChain;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonSpecies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.projects.pokemon.mappers.PokeApiMapper.pokeApiFullToPokemonExpandedInfo;

@Slf4j
@Service
public class PokemonService {
    @Autowired
    private PokeApi externalPokeApi;

    public List<PokemonCardInfo> fetchCards(Integer startPoint, Integer packageSize)  {

        PokeApiPokemonResponse pokeApiPokemonResponse=  fetchPokemonList(startPoint, packageSize);

        return pokeApiPokemonResponse
                    .getResults()
                    .stream()
                        .map(pokeApiPokemonShortInfoResponse -> fetchPokemonFullInfo(pokeApiPokemonShortInfoResponse.getName()))
                        .map(PokeApiMapper::pokeApiFullToPokemonCard)
                        .collect(Collectors.toList());
    }

    public PokemonExpandedInfo fetchPokemon(String name) {
        PokeApiPokemonFullInfoResponse pokeApiPokemonFullInfoResponse = fetchPokemonFullInfo(name);

        try {
            Response<PokeApiPokemonSpecies> response = externalPokeApi.getPokemonSpecie(pokeApiPokemonFullInfoResponse.getId()).execute();

            if (!response.isSuccessful()){
                throw new PokeApiNotSuccessfulResponseException(response.errorBody().string());
            }

            PokeApiPokemonSpecies species = response.body();

            System.out.println(species);

            String [] s = species.getEvolution_chain().getUrl().split("/");

            Integer evolutionChainId = Integer.valueOf(s[s.length - 1 ]) ;

            log.info("Evolution chain id ->" + String.valueOf(evolutionChainId));


            Response<PokeApiPokemonEvolutionChain> responseTwo = externalPokeApi.getPokemonEvolution(evolutionChainId).execute();

            if (!responseTwo.isSuccessful()){
                throw new PokeApiNotSuccessfulResponseException(response.errorBody().string());
            }

            PokeApiPokemonEvolutionChain evolutionChain = responseTwo.body();

            System.out.println(evolutionChain);



            return pokeApiFullToPokemonExpandedInfo(pokeApiPokemonFullInfoResponse, species, evolutionChain);


        } catch (IOException e) {
            throw new PokeApiIOException(e.getMessage());
        }

    }

    // Lets use the command pattern

    public PokeApiPokemonResponse fetchPokemonList (Integer startPoint, Integer packageSize) {
        try {
            return fetchPokemonListFromPokeApi(startPoint, packageSize);
        } catch (IOException e) {
            throw new PokeApiIOException(e.getMessage());
        }
    }

    private PokeApiPokemonResponse fetchPokemonListFromPokeApi (Integer startPoint, Integer packageSize) throws IOException {
        Response<PokeApiPokemonResponse> response =
                externalPokeApi.getPokemon(startPoint,packageSize).execute();

        if (!response.isSuccessful()){

            throw new PokeApiNotSuccessfulResponseException(response.errorBody().string());
        }
        return response.body();
    }

    public PokeApiPokemonFullInfoResponse fetchPokemonFullInfo (String pokeName) {
        try {
            return fetchPokemonFullInfoFromPokeApi(pokeName);
        } catch (IOException e) {
            throw new PokeApiIOException(e.getMessage());
        }
    }

    private PokeApiPokemonFullInfoResponse fetchPokemonFullInfoFromPokeApi (String pokeName) throws IOException {
        Response<PokeApiPokemonFullInfoResponse> response =
                externalPokeApi.getPokemonByName(pokeName).execute();
        if (!response.isSuccessful()){

            log.error(String.valueOf(response.code()));
            if (response.code() == HttpStatus.NOT_FOUND.value())
                throw new PokeApiNotFoundException(pokeName);

            throw new PokeApiNotSuccessfulResponseException(response.errorBody().string());
        }
        return response.body();
    }


}
