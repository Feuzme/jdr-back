package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.ModelSheet;

public interface ModelSheetRepo extends MongoRepository<ModelSheet, String> {

}
