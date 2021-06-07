package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.Session;

public interface SessionRepository extends MongoRepository<Session, String> {

}
