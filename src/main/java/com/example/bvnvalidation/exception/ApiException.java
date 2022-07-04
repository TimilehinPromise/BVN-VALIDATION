package com.example.bvnvalidation.exception;

public class ApiException {

    private final String message;
    private final String code;


    public ApiException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
