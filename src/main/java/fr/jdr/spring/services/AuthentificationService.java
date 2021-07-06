package fr.jdr.spring.services;

import org.springframework.stereotype.Service;

import fr.jdr.spring.dto.ConnexionDTO;


public interface AuthentificationService {

	String connexion(ConnexionDTO dto);

}