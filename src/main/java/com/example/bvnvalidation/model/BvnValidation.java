package com.example.bvnvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BvnValidation {

    private String imageDetail;
    private String basicDetail;
    private String message;
    private String code;
    private String bvn;


}
