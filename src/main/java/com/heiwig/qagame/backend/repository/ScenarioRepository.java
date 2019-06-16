package com.heiwig.qagame.backend.repository;

import com.heiwig.qagame.backend.entity.Scenario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ScenarioRepository extends MongoRepository<Scenario, String> {
}
