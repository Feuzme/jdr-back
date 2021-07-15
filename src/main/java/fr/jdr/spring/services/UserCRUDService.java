package fr.jdr.spring.services;

import fr.jdr.spring.models.User;

public interface UserCRUDService extends GenericCRUDService<User> {

	void deleteById(String id);

}
