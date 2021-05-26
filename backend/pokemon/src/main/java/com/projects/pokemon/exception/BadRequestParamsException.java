package com.projects.pokemon.exception;

import org.springframework.http.HttpStatus;

import static com.projects.pokemon.util.PokemonConstants.BAD_PARAMS;

public class BadRequestParamsException extends GeneralException{
    public BadRequestParamsException() {
        super( GeneralExceptionParams.builder()
                .messageException("Bad input params.")
                .errorLabel(BAD_PARAMS)
                .status(HttpStatus.BAD_REQUEST)
                .build());
    }
}
