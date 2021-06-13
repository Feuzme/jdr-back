package fr.jdr.spring.services.servicesimpl;

import com.fasterxml.jackson.databind.ObjectMapper;



public class UtilisateurServiceImpl extends GenericCRUDServiceImpl<User> implements UserService{

	public UtilisateurServiceImpl(UserRepository repository, ObjectMapper mapperParam) {
		super(repository);
	}

}
