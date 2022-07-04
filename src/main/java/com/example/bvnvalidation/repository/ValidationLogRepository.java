package com.example.bvnvalidation.repository;

import com.example.bvnvalidation.entity.ValidationLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationLogRepository extends MongoRepository<ValidationLog,String> {
}
