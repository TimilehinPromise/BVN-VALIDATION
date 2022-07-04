package com.example.bvnvalidation.entity;

import com.example.bvnvalidation.dto.ValidationDto;
import com.example.bvnvalidation.model.BvnValidation;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class ValidationLog {
    @Id
    private String Id;
    private ValidationDto request;
    private BvnValidation response;
    @CreatedDate
    protected LocalDateTime createdAt;

    @LastModifiedDate
    protected LocalDateTime updatedAt;

    public ValidationLog(ValidationDto request, BvnValidation response, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.request = request;
        this.response = response;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
