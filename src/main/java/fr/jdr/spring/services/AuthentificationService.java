package fr.jdr.spring.services;

import fr.jdr.spring.models.User;
import org.springframework.stereotype.Service;

import fr.jdr.spring.dto.ConnexionDTO;


public interface AuthentificationService {

	User
	connexion(ConnexionDTO dto);

}
