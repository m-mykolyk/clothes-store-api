package com.mykolyk.clothesstoreapi.controller;

import com.mykolyk.clothesstoreapi.model.enums.ErrorType;
import com.mykolyk.clothesstoreapi.exception.ServiceException;
import com.mykolyk.clothesstoreapi.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException: message: {}", e.getMessage(), e);
        return e.getBindingResult().getAllErrors().stream()
                .map(err -> new Error(err.getDefaultMessage(), ErrorType.VALIDATION_ERROR_TYPE, LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleServiceException(ServiceException e, HandlerMethod hm) {
        log.error("handleServiceException: message: {}, method: {}", e.getMessage(), hm.getMethod().getName(), e);
        return new Error(e.getMessage(), e.getErrorType(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleException(Exception e, HandlerMethod hm) {
        log.error("handleException: message: {}, method: {}", e.getMessage(), hm.getMethod().getName(), e);
        return new Error(e.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
    }
}
