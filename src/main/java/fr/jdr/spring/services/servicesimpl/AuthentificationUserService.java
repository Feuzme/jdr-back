package fr.jdr.spring.services.servicesimpl;

import java.util.Optional;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import fr.jdr.spring.dto.ConnexionDTO;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.services.AuthentificationService;



public class AuthentificationUserService implements AuthentificationService{

	private UserRepository repository;
	
	public AuthentificationUserService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public String connexion(ConnexionDTO dto) {
		// Trouver l'utilisateur en fonction de l'username ou email
		Optional<User> optional = this.repository.findFirstByNomOrEmail(
				dto.getUsernameOrEmail(), 
				dto.getUsernameOrEmail());
		User utilisateur = optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if (utilisateur.getPassword().equals(Base64.encode(dto.getPassword().getBytes())))
			return utilisateur.getId();
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}
