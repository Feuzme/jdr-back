package fr.jdr.spring.services.servicesimpl;

import java.time.LocalDateTime;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jdr.spring.dto.CreationUserDTO;
import fr.jdr.spring.dto.ModificationUsernameDTO;
import fr.jdr.spring.dto.UserDTO;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.services.ModificationUserService;
import fr.jdr.spring.services.UserService;


public class ModificationUserServiceImpl implements ModificationUserService{

	private ObjectMapper mapper;
	private UserRepository repository;
	private UserService service;
	
	public ModificationUserServiceImpl(ObjectMapper mapper, UserRepository repository,
			UserService service) {
		super();
		this.mapper = mapper;
		this.repository = repository;
		this.service = service;
	}

	@Override
	public UserDTO creationNouveauUtilisateur(CreationUserDTO dto) {
		checkCreationUtilisateur(dto);
		User entity = this.mapper.convertValue(dto, User.class);
		entity.setPassword(dto.getPassword());
		entity.setCreateAt(LocalDateTime.now());
		entity.setUpdateAt(LocalDateTime.now());
		User result = this.repository.save(entity);
		return this.mapper.convertValue(result, UserDTO.class);
	}
	
	private void checkCreationUtilisateur(CreationUserDTO dto) {
		if (dto.getEmail()==null || dto.getNom()==null || dto.getPassword()==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public UserDTO modificationUsernamePassword(ModificationUsernameDTO  dto) {
		//System.out.println(dto.getId());
		User utilisateur = this.repository.findById(dto.getId()).get();
		//System.out.println(utilisateur);
		if(dto.getNom()!=null)
			utilisateur.setNom(dto.getNom());
		if(dto.getEmail() != null)
			utilisateur.setEmail(dto.getEmail());
		if(dto.getBio() != null)
			utilisateur.setBio(dto.getBio());
		if(dto.getAvatar() != null)
			utilisateur.setAvatar(null); 
		if(dto.getVille() != null)
			utilisateur.setVille(dto.getVille());
		User result = this.repository.save(utilisateur);
		return this.mapper.convertValue(result, UserDTO.class);
	}

}
