package fr.jdr.spring.services.servicesimpl;

import java.util.Optional;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import fr.jdr.spring.dto.ConnexionDTO;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.services.AuthentificationService;



public class AuthentificationUserServiceImpl implements AuthentificationService{

	private UserRepository repository;
	
	public AuthentificationUserServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public String connexion(ConnexionDTO dto) {
		// Trouver l'utilisateur en fonction de l'email
		Optional<User> optional = this.repository.findFirstByEmail(dto.getEmail());
				
		User utilisateur = optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		System.out.println(utilisateur);
		if (utilisateur.getPassword().equals(dto.getPassword())) {
			System.out.println("le mot de passe est ok"+utilisateur);
			return utilisateur.getId();
		}
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}
