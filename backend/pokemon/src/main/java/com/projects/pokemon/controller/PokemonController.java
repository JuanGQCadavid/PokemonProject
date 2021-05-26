package com.projects.pokemon.controller;

import com.projects.pokemon.exception.BadRequestParamsException;
import com.projects.pokemon.exception.ErrorMessage;
import com.projects.pokemon.exception.GeneralException;
import com.projects.pokemon.exception.GeneralExceptionParams;
import com.projects.pokemon.model.PokemonCardInfo;
import com.projects.pokemon.model.PokemonExpandedInfo;
import com.projects.pokemon.service.PokemonService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.projects.pokemon.util.PokemonConstants.DEFAULT_CONTROLLER_GET_LIMIT_VALUE;
import static com.projects.pokemon.util.PokemonConstants.DEFAULT_CONTROLLER_GET_START_VALUE;
import static com.projects.pokemon.util.Validators.isValidNumber;

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

        if (!isValidNumber(startPoint) || !isValidNumber(packageSize)) {
            throw new BadRequestParamsException();
        }

        return new ResponseEntity( pokemonService.fetchCards(Integer.valueOf(startPoint), Integer.valueOf(packageSize)), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<PokemonExpandedInfo> fetchPokemonExpandedInfo (@PathVariable(required = true) String name){
        log.info(String.format("POKEMON | GET | POKEMON EXPANDED | NAME -> %s  ", name));

        return new ResponseEntity( pokemonService.fetchPokemon(name), HttpStatus.OK);
    }
}
