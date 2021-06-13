package fr.jdr.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.jdr.spring.models.BasePlugin;

public interface BasePluginRepository extends MongoRepository<BasePlugin, String>{

}
