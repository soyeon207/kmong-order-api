package com.kmong.memberorderapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            RuntimeException.class,
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleRuntime(Exception ex) {
        return ExceptionResponse
                .builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler({
            BadCredentialsException.class,
    })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ExceptionResponse handleUnauthorized(Exception ex) {
        return ExceptionResponse
                .builder()
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            IllegalArgumentException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse handleBadRequest(Exception ex) {
        if (ex.getClass().isAssignableFrom(MethodArgumentNotValidException.class)) {
            MethodArgumentNotValidException errorEx = (MethodArgumentNotValidException) ex;
            return ExceptionResponse.builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .message(errorEx
                            .getBindingResult()
                            .getFieldErrors()
                            .stream()
                            .map(v -> String.format("%s [%s]", v.getDefaultMessage(), v.getField()))
                            .collect(Collectors.joining(", ")))
                    .build();
        }

        return ExceptionResponse
                .builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
    }

}
