package com.airpremia.eosh.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExpectedException extends RuntimeException {
    private final ExceptionCode statusCode;

    @Override
    public String getMessage() {
        return "[" + statusCode + "] " + super.getMessage();
    }

    public ExceptionCode getExceptionCode() {
        return statusCode;
    }
}
