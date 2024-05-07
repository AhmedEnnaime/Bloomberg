package com.progress.bloomberg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdAlreadyExistsException extends RuntimeException{

    public IdAlreadyExistsException(String message) {
        super(message);
    }
}
