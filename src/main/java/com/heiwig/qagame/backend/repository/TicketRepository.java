package com.heiwig.qagame.backend.repository;

import com.heiwig.qagame.backend.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketRepository extends MongoRepository<Ticket, String> {
}
