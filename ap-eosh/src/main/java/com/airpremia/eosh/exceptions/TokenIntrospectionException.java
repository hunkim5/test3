package com.airpremia.eosh.exceptions;

public class TokenIntrospectionException extends RuntimeException {
    public TokenIntrospectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenIntrospectionException(String message) {
        super(message);
    }
}
