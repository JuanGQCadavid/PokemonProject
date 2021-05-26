package com.projects.pokemon.service;

import com.projects.pokemon.commands.FetchPokemonEvolutionCommand;
import com.projects.pokemon.commands.FetchPokemonFullInfoCommand;
import com.projects.pokemon.commands.FetchPokemonListCommand;
import com.projects.pokemon.commands.FetchPokemonSpecieCommand;
import com.projects.pokemon.commands.receivers.FetchPokemonEvolutionReceiver;
import com.projects.pokemon.commands.receivers.FetchPokemonFullInfoReceiver;
import com.projects.pokemon.commands.receivers.FetchPokemonListReceiver;
import com.projects.pokemon.commands.receivers.FetchPokemonSpecieReceiver;
import com.projects.pokemon.mappers.PokeApiMapper;
import com.projects.pokemon.model.PokemonCardInfo;
import com.projects.pokemon.model.PokemonExpandedInfo;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonEvolutionChain;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonFullInfoResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonResponse;
import com.projects.pokemon.model.pokeApiService.response.PokeApiPokemonSpecies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.projects.pokemon.mappers.PokeApiMapper.pokeApiFullToPokemonExpandedInfo;

@Slf4j
@Service
public class PokemonService {
    @Autowired
    private PokeApi externalPokeApi;

    @Autowired
    private FetchPokemonListReceiver fetchPokemonListReceiver;

    @Autowired
    private FetchPokemonFullInfoReceiver fetchPokemonFullInfoReceiver;

    @Autowired
    private FetchPokemonSpecieReceiver specieReceiver;

    @Autowired
    private FetchPokemonEvolutionReceiver evolutionReceiver;
    
    public List<PokemonCardInfo> fetchCards(Integer startPoint, Integer packageSize)  {

        FetchPokemonListCommand commandList = new FetchPokemonListCommand(startPoint, packageSize, fetchPokemonListReceiver);
        PokeApiPokemonResponse pokeApiPokemonResponse =  commandList.execute().getResult();

        return pokeApiPokemonResponse
                    .getResults()
                    .stream()
                        .map(pokeApiPokemonShortInfoResponse -> new FetchPokemonFullInfoCommand(pokeApiPokemonShortInfoResponse.getName(), fetchPokemonFullInfoReceiver)
                                .execute()
                                .getResult()
                        )
                        .map(PokeApiMapper::pokeApiFullToPokemonCard)
                        .collect(Collectors.toList());
    }

    public PokemonExpandedInfo fetchPokemon(String name) {
        FetchPokemonFullInfoCommand fetchPokemonFullInfoCommand =
                new FetchPokemonFullInfoCommand(name, fetchPokemonFullInfoReceiver);

        PokeApiPokemonFullInfoResponse pokeApiPokemonFullInfoResponse = fetchPokemonFullInfoCommand.execute().getResult();

        FetchPokemonSpecieCommand fetchPokemonSpecieCommand =
                new FetchPokemonSpecieCommand(pokeApiPokemonFullInfoResponse.getId(), specieReceiver);

        PokeApiPokemonSpecies species = fetchPokemonSpecieCommand.execute().getResult();

        Integer evolutionChainId = getEvolutionId(species.getEvolution_chain().getUrl());

        FetchPokemonEvolutionCommand evolutionCommand =
                new FetchPokemonEvolutionCommand(evolutionChainId, evolutionReceiver);

        PokeApiPokemonEvolutionChain evolutionChain = evolutionCommand.execute().getResult();

        return pokeApiFullToPokemonExpandedInfo(pokeApiPokemonFullInfoResponse, species, evolutionChain);
    }

    private Integer getEvolutionId(String url){
        String [] urlSplit = url.split("/");

        Integer evolutionChainId = Integer.valueOf(urlSplit[urlSplit.length - 1 ]) ;

        log.info("Evolution chain id ->" + String.valueOf(evolutionChainId));

        return evolutionChainId;
    }

}
