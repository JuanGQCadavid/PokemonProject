package com.projects.pokemon.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static com.projects.pokemon.util.PokemonConstants.POKE_API_NOT_SUCCESS;

@Slf4j
public class PokeApiNotSuccessfulResponseException extends GeneralException{
    public PokeApiNotSuccessfulResponseException(String errorMessage) {
        super(GeneralExceptionParams.builder()
                .messageException("Internal error when consuming other service.")
                .errorLabel(POKE_API_NOT_SUCCESS)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build());
        log.error(String.format("PokeApi not successful response -> %s ", errorMessage));
    }
}
