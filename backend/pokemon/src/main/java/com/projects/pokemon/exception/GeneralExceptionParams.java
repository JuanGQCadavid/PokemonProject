package com.projects.pokemon.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneralExceptionParams {

    private String messageException;
    private HttpStatus status;
    private String errorLabel;
    private Object payload;
}
