package com.example.bvnvalidation.service.concretes;

import com.example.bvnvalidation.constants.ResponseEnum;
import com.example.bvnvalidation.dto.ValidationDto;
import com.example.bvnvalidation.entity.Bvn;
import com.example.bvnvalidation.entity.ValidationLog;
import com.example.bvnvalidation.exception.ApiInvalidRequestException;
import com.example.bvnvalidation.exception.ApiRequestException;
import com.example.bvnvalidation.model.BvnValidation;
import com.example.bvnvalidation.repository.BvnRepository;
import com.example.bvnvalidation.repository.ValidationLogRepository;
import com.example.bvnvalidation.service.abstracts.BvnValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BvnValidationServiceImpl implements BvnValidationService {
    private final BvnRepository bvnRepository;
    private final ValidationLogRepository logRepository;


    @Override
    public BvnValidation bvnValidation(ValidationDto validationDto)  {
        String regex = "[0-9]+";
        if (validationDto.getBvn().isEmpty()){
            buildValidationEmptyError(validationDto);
        throw new ApiRequestException("One or more of your request parameters failed validation. Please retry","400");
        }
        if (validationDto.getBvn().length()<=10){
            buildValidationInvalidLengthError(validationDto);
            throw new ApiRequestException("The searched BVN is invalid","02");
        }
        if (!validationDto.getBvn().matches(regex)){
            buildValidationInvalidCharacterError(validationDto);
            throw new ApiInvalidRequestException("The searched BVN is invalid","02",validationDto.getBvn());
        }
        Optional<Bvn> found = bvnRepository.findByBvnNumber(validationDto.getBvn());

        if (found.isEmpty()){
         buildFailedValidation(validationDto);
         throw new ApiInvalidRequestException("The searched BVN does not exist","01",validationDto.getBvn());
        }
        if (found.isPresent()){
            Bvn bvn = found.get();
            return buildSuccessfulValidation(bvn,validationDto);
        }

return null;

    }

    public BvnValidation buildValidationInvalidLengthError(ValidationDto validationDto){
        ResponseEnum responseEnum =   ResponseEnum.PAYLOAD_LENGTH_ERROR;
        BvnValidation bvnValidation = new BvnValidation();
        bvnValidation.setBvn(validationDto.getBvn());
        bvnValidation.setCode(responseEnum.getCode());
        bvnValidation.setMessage(responseEnum.getMessage());
        bvnValidation.setBvn(validationDto.getBvn());

        ValidationLog validationLog = new ValidationLog(validationDto,bvnValidation, LocalDateTime.now(),LocalDateTime.now());
        logRepository.insert(validationLog);
        return bvnValidation;
    }
    public BvnValidation buildValidationInvalidCharacterError(ValidationDto validationDto){
        ResponseEnum responseEnum =   ResponseEnum.PAYLOAD_CHARACTER_ERROR;
        BvnValidation bvnValidation = new BvnValidation();
        bvnValidation.setBvn(validationDto.getBvn());
        bvnValidation.setCode(responseEnum.getCode());
        bvnValidation.setMessage(responseEnum.getMessage());
        bvnValidation.setBvn(validationDto.getBvn());

        ValidationLog validationLog = new ValidationLog(validationDto,bvnValidation, LocalDateTime.now(),LocalDateTime.now());
        logRepository.insert(validationLog);
        return bvnValidation;
    }

    public BvnValidation buildValidationEmptyError(ValidationDto validationDto){
        ResponseEnum responseEnum =   ResponseEnum.EMPTY_BVN;
        BvnValidation bvnValidation = new BvnValidation();
        bvnValidation.setBvn(validationDto.getBvn());
        bvnValidation.setCode(responseEnum.getCode());
        bvnValidation.setMessage(responseEnum.getMessage());

        ValidationLog validationLog = new ValidationLog(validationDto,bvnValidation, LocalDateTime.now(),LocalDateTime.now());
        logRepository.insert(validationLog);
        return bvnValidation;
    }

    public BvnValidation buildSuccessfulValidation(Bvn bvn,ValidationDto validationDto){
        ResponseEnum responseEnum =   ResponseEnum.SUCCESS;
        BvnValidation bvnValidation = new BvnValidation();
        bvnValidation.setBvn(bvn.getBvnNumber());
        bvnValidation.setCode(responseEnum.getCode());
        bvnValidation.setMessage(responseEnum.getMessage());
        bvnValidation.setBasicDetail(bvn.getBasicDetails());
        bvnValidation.setImageDetail(bvn.getImageDetail());

        ValidationLog validationLog = new ValidationLog(validationDto,bvnValidation, LocalDateTime.now(),LocalDateTime.now());
        logRepository.insert(validationLog);
        return bvnValidation;
    }

    public BvnValidation buildFailedValidation(ValidationDto validationDto){
        ResponseEnum responseEnum =   ResponseEnum.INVALID_BVN;
        BvnValidation bvnValidation = new BvnValidation();
        bvnValidation.setBvn(validationDto.getBvn());
        bvnValidation.setCode(responseEnum.getCode());
        bvnValidation.setMessage(responseEnum.getMessage());

        ValidationLog validationLog = new ValidationLog(validationDto,bvnValidation, LocalDateTime.now(),LocalDateTime.now());
        logRepository.insert(validationLog);
        return bvnValidation;
    }



}
