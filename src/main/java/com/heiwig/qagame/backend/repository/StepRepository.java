package com.heiwig.qagame.backend.repository;

import com.heiwig.qagame.backend.entity.Step;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StepRepository extends MongoRepository<Step, String> {
}
