package fr.jdr.spring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



import fr.jdr.spring.models.User;

public interface UserRepository  extends MongoRepository<User, Long> {

	
	public List<User> findByNom(String nom);

	public List<User> findByNomLike(String nom);
	
}
