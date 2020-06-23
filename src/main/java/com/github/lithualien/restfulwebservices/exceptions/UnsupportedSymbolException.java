package com.github.lithualien.restfulwebservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedSymbolException extends RuntimeException {

    public UnsupportedSymbolException(String message) {
        super(message);
    }
}
