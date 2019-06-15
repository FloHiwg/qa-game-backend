package com.heiwig.qagame.backend.repository;

import com.heiwig.qagame.backend.entity.Case;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends MongoRepository<Case, String> {
}
