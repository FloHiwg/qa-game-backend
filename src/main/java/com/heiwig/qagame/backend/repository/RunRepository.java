package com.heiwig.qagame.backend.repository;

import com.heiwig.qagame.backend.entity.Run;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunRepository extends MongoRepository<Run, String> {
}