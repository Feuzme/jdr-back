package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.ComposantStandard;

public interface ComposantStandardRepository extends MongoRepository<ComposantStandard, String>{

}
