package fr.jdr.spring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.Game;

public interface GameRepository extends MongoRepository<Game, String> {
	
	public List<Game> findByMjUserLike(String id);
}
