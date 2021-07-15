package fr.jdr.spring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.Creneau;

public interface CreneauRepository extends MongoRepository<Creneau, String>{

	public List<Creneau> findByGame(String gameId);
}
