package fr.jdr.spring.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import fr.jdr.spring.models.User;



public interface UserRepository  extends MongoRepository<User, String> {

	
	public Optional<User> findFirstByNomOrEmail(String nom, String email);
	

	
	
}
