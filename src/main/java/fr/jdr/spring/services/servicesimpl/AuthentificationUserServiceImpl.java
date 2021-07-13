package fr.jdr.spring.services.servicesimpl;

import fr.jdr.spring.dto.ConnexionDTO;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.services.AuthentificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.regex.Pattern;


public class AuthentificationUserServiceImpl implements AuthentificationService {

	private UserRepository repository;

	public AuthentificationUserServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public User connexion(ConnexionDTO dto) {
		// Trouver l'utilisateur en fonction de l'email
		Optional<User> optional;
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		if (pattern.matcher(dto.getNameOrEmail()).find()) {
			optional = this.repository.findFirstByEmail(dto.getNameOrEmail());
		} else {
			optional = this.repository.findFirstByNom(dto.getNameOrEmail());
		}

		User utilisateur = optional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		System.out.println(utilisateur);
		if (utilisateur.getPassword().equals(dto.getPassword())) {
			System.out.println("le mot de passe est ok" + utilisateur);
			return utilisateur;
		}
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}
