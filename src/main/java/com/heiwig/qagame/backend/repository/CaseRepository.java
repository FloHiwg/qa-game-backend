package com.heiwig.qagame.backend.repository;

import com.heiwig.qagame.backend.entity.Case;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CaseRepository extends MongoRepository<Case, String> {
}
