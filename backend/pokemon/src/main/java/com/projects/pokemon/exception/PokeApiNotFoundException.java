package com.projects.pokemon.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static com.projects.pokemon.util.PokemonConstants.POKE_API_NOT_FOUND;

@Slf4j
public class PokeApiNotFoundException extends GeneralException{
    public PokeApiNotFoundException(String errorMessage) {
        super(GeneralExceptionParams.builder()
                .messageException("Pokemon not found ")
                .errorLabel(POKE_API_NOT_FOUND)
                .status(HttpStatus.NOT_FOUND)
                .payload(errorMessage)
                .build());
    }
}
