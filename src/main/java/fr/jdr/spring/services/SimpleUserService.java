package fr.jdr.spring.services;

import java.util.List;

import fr.jdr.spring.dto.SimpleUserDTO;


public interface SimpleUserService {

	SimpleUserDTO findSimpleUtilisateurById(String id);

	List<SimpleUserDTO> trouverToutLesUtilisateurs();

}