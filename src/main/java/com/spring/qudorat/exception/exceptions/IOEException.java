package com.spring.qudorat.exception.exceptions;

import org.springframework.http.HttpStatus;

public class IOEException extends BaseException {

    public IOEException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return  HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
