package com.example.bvnvalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationDto {
//    @NotBlank(message = "One or more of your request parameters failed validation. Please retry")
//    @Size(min = 11,message = "The searched BVN is invalid")
//    @Pattern(regexp = "[0-9]+",message = "The searched BVN is invalid")
    private String bvn;
}
