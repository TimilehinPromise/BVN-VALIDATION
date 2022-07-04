package com.example.bvnvalidation;

import com.example.bvnvalidation.dto.ValidationDto;
import com.example.bvnvalidation.entity.Bvn;
import com.example.bvnvalidation.entity.ValidationLog;
import com.example.bvnvalidation.model.BvnValidation;
import com.example.bvnvalidation.repository.BvnRepository;
import com.example.bvnvalidation.repository.ValidationLogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BvnValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BvnValidationApplication.class, args);
    }




    @Bean
    CommandLineRunner runner (ValidationLogRepository repository){
        return args -> {
            ValidationDto request = new ValidationDto("22526136104");
            BvnValidation response = new BvnValidation("sdsf","fornow"
            , "smart ass","00","22526136104");
            ValidationLog validationLog = new ValidationLog(request,response, LocalDateTime.now(),LocalDateTime.now());
            repository.insert(validationLog);
        };

    }
    @Bean
    CommandLineRunner runnerT (BvnRepository repository){
        return args -> {
//            Bvn bvn = new Bvn("22526136104");
            List<Bvn> list = new ArrayList<>();
            list.add(new Bvn("22526136104","basicDetailsOne","imageDetails1"));
            list.add(new Bvn("66906136104","basicDetailsTwo","imageDetails2"));
            list.add(new Bvn("66906158104","basicDetailsThree","imageDetails3"));
            repository.insert(list);
        };
    }
}
