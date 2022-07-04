package com.example.bvnvalidation.exception;

import lombok.Data;

@Data
public class ApiInvalidRequestException extends RuntimeException {
    private String message;
    private String code;
    private String bvn;



    public ApiInvalidRequestException(String message,String code,String bvn) {
        this.message =message;
        this.code = code;
        this.bvn = bvn;
    }


}
