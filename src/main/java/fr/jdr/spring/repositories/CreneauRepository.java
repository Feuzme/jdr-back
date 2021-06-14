package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.Creneau;

public interface CreneauRepository extends MongoRepository<Creneau, String>{

}
