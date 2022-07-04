package com.example.bvnvalidation.exception;

public class ApiInvalidException {

    private final String message;
    private final String code;
    private final String bvn;

    public ApiInvalidException(String message, String code, String bvn) {
        this.message = message;
        this.code = code;
        this.bvn = bvn;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getBvn() {
        return bvn;
    }
}
