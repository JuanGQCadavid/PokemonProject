package com.projects.pokemon.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static com.projects.pokemon.util.PokemonConstants.POKE_API_IO_EXCEPTION;

@Slf4j
public class PokeApiIOException extends GeneralException{
    public PokeApiIOException(String msg) {
        super(GeneralExceptionParams.builder()
                .messageException("Internal error when consuming other service.")
                .errorLabel(POKE_API_IO_EXCEPTION)
                .status(HttpStatus.BAD_GATEWAY)
                .build());

        log.error(String.format("PokeApiIOException -> ERROR -> %s ",msg));
    }
}
