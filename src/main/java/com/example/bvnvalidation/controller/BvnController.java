package com.example.bvnvalidation.controller;

import com.example.bvnvalidation.dto.ValidationDto;
import com.example.bvnvalidation.model.BvnValidation;
import com.example.bvnvalidation.service.abstracts.BvnValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/bv-service")
@RequiredArgsConstructor
public class BvnController {

private final BvnValidationService bvnValidationService;


    @PostMapping("/bv-service/svalidate/wrapper")
    public BvnValidation validate (@RequestBody ValidationDto validationDto) {

return bvnValidationService.bvnValidation(validationDto);
    }
}
