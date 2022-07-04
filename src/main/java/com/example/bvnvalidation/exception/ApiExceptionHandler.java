package com.example.bvnvalidation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
       ApiException apiException = new ApiException(
                e.getMessage(),
                e.getCode()
        );

       return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = {ApiInvalidRequestException.class})
    public ResponseEntity<Object> handleApiRequestExceptionTwo(ApiInvalidRequestException e){
        ApiInvalidException apiException = new ApiInvalidException(
                e.getMessage(),
                e.getCode(),
                e.getBvn()
        );

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);

    }
}
