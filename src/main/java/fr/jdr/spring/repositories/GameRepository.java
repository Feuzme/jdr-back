package fr.jdr.spring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.Game;
import fr.jdr.spring.models.User;

public interface GameRepository extends MongoRepository<Game, String> {
	
	public List<Game> findByMjUser(String id);
	public List<Game> findByListPlayers(String id);
}
