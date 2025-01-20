package com.airpremia.eosh.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SlackException extends RuntimeException {
    private final ExceptionCode statusCode;

    @Override
    public String getMessage() {
        return statusCode.getMessage();
    }
}
