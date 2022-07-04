package com.example.bvnvalidation.exception;

import lombok.Data;

@Data
public class ApiRequestException extends RuntimeException {
    private String message;
    private String code;




    public ApiRequestException(String message,String code) {
        this.message =message;
        this.code = code;
    }


}
