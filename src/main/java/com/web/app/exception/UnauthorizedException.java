package com.web.app.exception;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(String msg) {
        super(msg);
    }
}
