package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.GameType;

public interface GameTypeRepository extends MongoRepository<GameType, String> {

}
