package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.models.User;
import fr.jdr.spring.services.UserService;


@RestController
@RequestMapping("users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	
	
	
	
	
	@GetMapping()
	public List<User> getALL() {
		return userService.getAll() ;
	}
	@GetMapping("{id}")
	public User getbyId(@PathVariable Long id) {
		return this.userService.getById(id); 
	}
	
	@GetMapping("/nom/{nom}")
	public List<User> findByNom(@PathVariable String nom) {
		return this.userService.findByNom(nom) ;
	}
/*	
	@GetMapping("/nom/{nom}")
	public List<User> findByNomLike(@PathVariable String nom) {
		return this.userService.findByNomLike(nom) ;
	}
*/	
	
	@PostMapping()
	public User save(@RequestBody User film ) {

		return userService.create(film);
	}
	
	@PatchMapping()
	public User update( @RequestBody User film) {
		return this.userService.update(film);
		
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		this.userService.delete(id);
		
	}
	

}
