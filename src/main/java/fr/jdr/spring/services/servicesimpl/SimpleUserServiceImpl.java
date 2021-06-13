package fr.jdr.spring.services.servicesimpl;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jdr.spring.dto.SimpleUserDTO;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.services.SimpleUserService;
import fr.jdr.spring.services.UserService;


public class SimpleUserServiceImpl implements SimpleUserService{

	private ObjectMapper mapper;
	private UserRepository repository;
	private UserService userService;

	public SimpleUserServiceImpl(ObjectMapper mapper, UserRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public List<SimpleUserDTO> trouverToutLesUtilisateurs() {
		List<User> utilisateurs = this.repository.findAll();
		
		/*
		return utilisateurs.stream().map(utilisateur->{
			return this.mapper.convertValue(utilisateur, SimpleUtilisateurDTO.class);
		}).collect(Collectors.toList());
		*/
		List<SimpleUserDTO> results = new ArrayList<>();
		for (User utilisateur : utilisateurs) {
			results.add(this.mapper.convertValue(utilisateur, SimpleUserDTO.class));
		}
		return results;
	}
	
	public SimpleUserDTO findSimpleUtilisateurById(String id) {
		User utilisateur = this.userService.findById(id);
		return mapper.convertValue(utilisateur, SimpleUserDTO.class);
	}
}
