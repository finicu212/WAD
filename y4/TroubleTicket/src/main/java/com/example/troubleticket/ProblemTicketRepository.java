package com.example.troubleticket;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProblemTicketRepository extends MongoRepository<ProblemTicket, Long> {
}
