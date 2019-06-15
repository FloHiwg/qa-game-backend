package com.heiwig.qagame.backend.repository;

import com.heiwig.qagame.backend.entity.Step;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends MongoRepository<Step, String> {
}
