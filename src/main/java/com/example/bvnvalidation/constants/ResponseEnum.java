package com.example.bvnvalidation.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseEnum {

    SUCCESS ("Success","00"),
    INVALID_BVN("The searched BVN does not exist","01"),
    EMPTY_BVN("One or more of your request parameters failed validation. Please retry","400"),
    PAYLOAD_LENGTH_ERROR("The searched BVN is invalid","02"),
    PAYLOAD_CHARACTER_ERROR("The searched BVN is invalid","400");

    private String message;
    private String code;



}
