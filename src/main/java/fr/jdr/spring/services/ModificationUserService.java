package fr.jdr.spring.services;

import fr.jdr.spring.dto.CreationUserDTO;
import fr.jdr.spring.dto.ModificationUsernameDTO;
import fr.jdr.spring.dto.UserDTO;

public interface ModificationUserService {

	UserDTO creationNouveauUtilisateur(CreationUserDTO dto);

	UserDTO modificationUsernamePassword(ModificationUsernameDTO  dto);

}