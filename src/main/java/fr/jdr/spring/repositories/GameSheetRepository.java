package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.GameSheet;

public interface GameSheetRepository extends MongoRepository<GameSheet, String> {

}
