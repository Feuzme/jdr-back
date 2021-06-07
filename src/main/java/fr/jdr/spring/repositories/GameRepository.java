package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.Game;

public interface GameRepository extends MongoRepository<Game, String> {

}
