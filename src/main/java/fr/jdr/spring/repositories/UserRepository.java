package fr.jdr.spring.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import fr.jdr.spring.models.User;



public interface UserRepository  extends MongoRepository<User, String> {


	Optional<User> findFirstByNom(String nom);
	Optional<User> findFirstByEmail(String email);
	Optional<User> findByEmailOrNom(String email, String nom);


	
	
}
