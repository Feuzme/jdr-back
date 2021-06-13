package fr.jdr.spring.services;

import fr.jdr.spring.dto.ConnexionDTO;

public interface AuthentificationService {

	String connexion(ConnexionDTO dto);

}