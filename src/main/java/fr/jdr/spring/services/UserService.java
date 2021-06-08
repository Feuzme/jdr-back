package fr.jdr.spring.services;

import java.util.List;

import fr.jdr.spring.dto.ConnexionDTO;
import fr.jdr.spring.dto.CreationUserDTO;
import fr.jdr.spring.dto.ModificationUserPasswordDTO;
import fr.jdr.spring.dto.SimpleUserDTO;
import fr.jdr.spring.dto.UserDTO;
import fr.jdr.spring.models.User;

public interface UserService  {

	/*
	public List<User> findByNom(String nom) ;
	public List<User> findByNomLike(String nom) ;
	public void deleteById(String id);
	*/
	
	public UserDTO creationNouveauUtilisateur(CreationUserDTO dto);

	public SimpleUserDTO findById(String id);

	public List<SimpleUserDTO> trouverToutLesUtilisateurs();


	public void supprimerUser(String id);

	public String connexion(ConnexionDTO dto);

	public UserDTO modificationUsernamePassword(ModificationUserPasswordDTO dto);
	
}
