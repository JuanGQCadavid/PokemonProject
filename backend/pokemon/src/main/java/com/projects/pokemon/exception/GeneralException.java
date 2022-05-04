package com.projects.pokemon.exception;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class GeneralException extends RuntimeException{
    private GeneralExceptionParams params;

    public GeneralException(GeneralExceptionParams params) {
        super(params.getMessageException());
        this.params = params;
    }

    public ErrorMessage generateErrorMessage(){
        return ErrorMessage.builder()
                .errorType(params.getErrorLabel())
                .message(params.getMessageException())
                .payload(params.getPayload())
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
