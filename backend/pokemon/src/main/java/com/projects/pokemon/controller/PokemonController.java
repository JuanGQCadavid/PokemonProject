package com.projects.pokemon.controller;

import com.projects.pokemon.model.PokemonCardInfo;
import com.projects.pokemon.service.PokemonService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.projects.pokemon.PokemonConstants.DEFAULT_CONTROLLER_GET_LIMIT_VALUE;
import static com.projects.pokemon.PokemonConstants.DEFAULT_CONTROLLER_GET_START_VALUE;

@RequestMapping("/api/v1/pokemon")
@Controller
@Slf4j
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @ApiOperation(
            value = "FETCH POKEMON'S CARDS",
            notes = "Fetch a list of pokemon's cards btw start and size query params limitations"
    )
    @GetMapping("/")
    public ResponseEntity<List<PokemonCardInfo>> fetchPokemonCards(
            @RequestParam(value = "start", required = false, defaultValue = DEFAULT_CONTROLLER_GET_START_VALUE) String startPoint,
            @RequestParam(value = "size", required = false, defaultValue = DEFAULT_CONTROLLER_GET_LIMIT_VALUE) String packageSize
    ){
        log.info(String.format("POKEMON | GET | POKEMON CARDS | START -> %s , SIZE -> %s ", startPoint, packageSize));

        // we need to handle bad type on start point and package size
        Integer startPointInt = Integer.valueOf(startPoint);
        Integer packageSizeInt = Integer.valueOf(packageSize);


        return new ResponseEntity( pokemonService.fetchCards(startPointInt, packageSizeInt), HttpStatus.OK);
    }


}
