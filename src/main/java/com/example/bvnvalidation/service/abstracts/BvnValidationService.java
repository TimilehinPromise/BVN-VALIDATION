package com.example.bvnvalidation.service.abstracts;

import com.example.bvnvalidation.dto.ValidationDto;
import com.example.bvnvalidation.model.BvnValidation;

public interface BvnValidationService {
    BvnValidation bvnValidation(ValidationDto validationDto) ;
}
