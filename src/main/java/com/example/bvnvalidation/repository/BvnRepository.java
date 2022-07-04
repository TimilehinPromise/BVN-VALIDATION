package com.example.bvnvalidation.repository;

import com.example.bvnvalidation.entity.Bvn;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BvnRepository extends MongoRepository<Bvn,String> {

   Optional<Bvn> findByBvnNumber(String bvn);
}
