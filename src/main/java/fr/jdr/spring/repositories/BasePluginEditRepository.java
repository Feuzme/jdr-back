package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.BasePluginEdit;

public interface BasePluginEditRepository extends MongoRepository<BasePluginEdit, String> {

}
