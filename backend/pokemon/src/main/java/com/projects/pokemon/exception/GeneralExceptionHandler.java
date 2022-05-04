package com.projects.pokemon.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GeneralExceptionHandler {

    /**
     * General error handler for all Poke exceptions family.
     * @param ex
     * @return
     */
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorMessage> pokeExceptionHandler(GeneralException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity(ex.generateErrorMessage(),ex.getParams().getStatus());

    }
}
