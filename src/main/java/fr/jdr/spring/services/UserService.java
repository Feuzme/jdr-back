package fr.jdr.spring.services;

import java.util.List;
import fr.jdr.spring.models.User;

public interface UserService extends GenericService<User> {

	
	public List<User> findByNom(String nom) ;
	public List<User> findByNomLike(String nom) ;
	
}
