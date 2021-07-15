package fr.jdr.spring.services.servicesimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.jdr.spring.dto.ConnexionDTO;
import fr.jdr.spring.dto.CreationUserDTO;
import fr.jdr.spring.dto.ModificationPasswordDTO;
import fr.jdr.spring.dto.ModificationUsernameDTO;
import fr.jdr.spring.dto.SimpleUserDTO;
import fr.jdr.spring.dto.UserDTO;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.services.UserService;


public class UserServiceImpl extends GenericCRUDServiceImpl<User> implements UserService {

	
	public UserServiceImpl(UserRepository repository, ObjectMapper mapperParam) {
		super(repository);
	}
	

	/*
	
	private ObjectMapper mapper;
	private UserRepository userRepository ;


	
	public UserServiceImpl(UserRepository userRepository, ObjectMapper mapperParam) {
		this.userRepository = userRepository;
		this.mapper = mapperParam;
	}
	
	

	@Override
	public UserDTO creationNouveauUtilisateur(CreationUserDTO dto) {
		checkCreationUser(dto);
		User entity = this.mapper.convertValue(dto, User.class);
		entity.setPassword(Base64.encode(dto.getPassword().getBytes()));
		entity.setCreateAt(LocalDateTime.now());
		entity.setUpdateAt(LocalDateTime.now());
		User result = this.userRepository.save(entity);
		return this.mapper.convertValue(result, UserDTO.class);
	}
	private void checkCreationUser(CreationUserDTO dto) {
		if (dto.getEmail()==null || dto.getNom() ==null || dto.getPassword()==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}



	@Override
	public SimpleUserDTO findById(String id) {
		User user = this.userRepository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		return mapper.convertValue(user, SimpleUserDTO.class);
	}



	@Override
	public List<SimpleUserDTO> trouverToutLesUtilisateurs() {
		List<User> users = this.userRepository.findAll();
		
		List<SimpleUserDTO> results = new ArrayList<>();
		for (User user : users) {
			results.add(this.mapper.convertValue(user, SimpleUserDTO.class));
		}
		return results;
	}
	
	
	
	@Override
	public void supprimerUser(String id) {
		if(this.userRepository.existsById(id))
			this.userRepository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

/**
 * methode pour modifier le username et le password
 */
	/*@Override
	public UserDTO modificationUsername(ModificationUsernameDTO dto) {
		User user = this.userRepository.findById(dto.getId())
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		if(dto.getNom()!=null)
			user.setNom(dto.getNom());
		if(dto.getEmail() != null)
			user.setEmail(dto.getEmail());
		User result = this.userRepository.save(user);
		return this.mapper.convertValue(result, UserDTO.class);
	}
	
	
	*/
	/*
	@Override
	public UserDTO modificationPassword(ModificationPasswordDTO dto) {
		User user = this.userRepository.findById(dto.getId())
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		if(dto.getPassword()!=null)
			user.setPassword(dto.getPassword());

		User result = this.userRepository.save(user);
		return this.mapper.convertValue(result, UserDTO.class);
	}
	



	@Override
	public String connexion(ConnexionDTO dto) {
		// Trouver l'utilisateur en fonction de l'username ou email
		Optional<User> optional = this.userRepository.findFirstByNomOrEmail(dto.getUsernameOrEmail(), dto.getUsernameOrEmail());
		User user = optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		//verification du password
		if (user.getPassword().equals(Base64.encode(dto.getPassword().getBytes())))
			//retourner l'id
			return user.getId();
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}





	
	
	

	@Override
	public String connexion(ConnexionDTO dto) {
		// Trouver l'utilisateur en fonction de l'username ou email
		Optional<User> optional = this.userRepository.findFirstByUsernameOrEmail(dto.getUsernameOrEmail(), dto.getUsernameOrEmail());
		User utilisateur = optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if (utilisateur.getPassword().equals(Base64.encode(dto.getPassword().getBytes())))
			return utilisateur.getId();
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}

	
	@Override
	public UserDTO modificationUsernamePassword(ModificationUserPasswordDTO dto) {
		User user = this.userRepository.findById(dto.getId())
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		if(dto.getUsername()!=null)
			user.setNom(dto.getUsername());
		if(dto.getEmail() != null)
			user.setEmail(dto.getEmail());
		User result = this.userRepository.save(user);
		return this.mapper.convertValue(result, UserDTO.class);
	}


	 
	@Override
	public String connexion(ConnexionDTO dto) {
		// Trouver l'user en fonction de l'username ou email
		Optional<User> optional = this.userRepository.findFirstByUsernameOrEmail(dto.getUsernameOrEmail(), dto.getUsernameOrEmail());
		User user = optional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if (user.getPassword().equals(Base64.encode(dto.getPassword().getBytes())))
			return user.getId();
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}

	
	*/

	
	
	


}
