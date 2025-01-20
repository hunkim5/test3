package com.airpremia.eosh.common.adviser;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.airpremia.eosh.exceptions.ErrorResponse;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;

@RestControllerAdvice
public class ErrorControllerAdviser {
    @ExceptionHandler(ExpectedException.class)
    protected HttpEntity<ErrorResponse> handleIllegalArgumentException(ExpectedException ex) {
        ExceptionCode errorCode = ex.getExceptionCode();

        ErrorResponse errorResponse = new ErrorResponse(
            errorCode.getCode(),
            errorCode.getMessage()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
