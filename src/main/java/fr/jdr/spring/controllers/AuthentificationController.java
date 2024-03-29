package fr.jdr.spring.controllers;

import fr.jdr.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.dto.ConnexionDTO;
import fr.jdr.spring.services.AuthentificationService;


@CrossOrigin
@RestController
@RequestMapping("auth")
public class AuthentificationController {
	
	@Autowired
	private AuthentificationService authService;
	
	@PostMapping("connexion")
	public User connexion(@RequestBody ConnexionDTO dto) {
		return this.authService.connexion(dto);
	}
}
