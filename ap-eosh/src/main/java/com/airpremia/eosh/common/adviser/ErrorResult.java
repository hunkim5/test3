package com.airpremia.eosh.common.adviser;

import com.airpremia.eosh.exceptions.ExceptionCode;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ErrorResult {
    private final ExceptionCode statusCode;
    private final String statusMessage;
}
