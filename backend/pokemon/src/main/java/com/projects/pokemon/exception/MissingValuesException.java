package com.projects.pokemon.exception;

import org.springframework.http.HttpStatus;

import static com.projects.pokemon.util.PokemonConstants.MISSING_FIELDS;

public class MissingValuesException extends GeneralException {
    public MissingValuesException(Object Payload) {
        super( GeneralExceptionParams.builder()
                .messageException("There is a problem with the fields format.")
                .errorLabel(MISSING_FIELDS)
                .status(HttpStatus.BAD_REQUEST)
                .payload(Payload)
                .build());
    }
}
