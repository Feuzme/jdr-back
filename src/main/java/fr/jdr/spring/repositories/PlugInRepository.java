package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.PlugIn;

public interface PlugInRepository extends MongoRepository<PlugIn, String> {

}
