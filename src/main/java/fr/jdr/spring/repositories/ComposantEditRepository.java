package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.ComposantEdit;

public interface ComposantEditRepository extends MongoRepository<ComposantEdit, String> {

}
