package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.dto.ConnexionDTO;
import fr.jdr.spring.dto.CreationUserDTO;
import fr.jdr.spring.dto.ModificationPasswordDTO;
import fr.jdr.spring.dto.ModificationUsernameDTO;
import fr.jdr.spring.dto.SimpleUserDTO;
import fr.jdr.spring.dto.UserDTO;
import fr.jdr.spring.models.User;
import fr.jdr.spring.models.User.Status;
import fr.jdr.spring.services.ModificationUserService;
import fr.jdr.spring.services.SimpleUserService;
import fr.jdr.spring.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	
	@Autowired
	private SimpleUserService simpleUserService;
	
	@Autowired
	private ModificationUserService modificationService;
	
	
	
	
	
	
	@PostMapping("")
	public UserDTO creationNouveauUtilisateur(@RequestBody CreationUserDTO dto) {
		return this.modificationService.creationNouveauUtilisateur(dto);
	}
	

	@GetMapping("{id}/detail")
	public User findByIdDetail(@PathVariable String id) {
		return this.userService.findById(id);
	}
	
	@GetMapping("{id}")
	public SimpleUserDTO findById(@PathVariable String id) {
		return this.simpleUserService.findSimpleUtilisateurById(id);
	}
	
	@GetMapping("")
	public List<SimpleUserDTO> findAll(){
		return this.simpleUserService.trouverToutLesUtilisateurs();
	}
	
	
	@DeleteMapping("{id}")
	public void supprimerParId(@PathVariable String id) {
		this.userService.deleteById(id);
	}
	
	
	@PatchMapping("")
	public UserDTO modificationUserNamePassword(@RequestBody ModificationUsernameDTO  dto) {
		System.out.println(dto);
		return this.modificationService.modificationUsernamePassword(dto);
	}
	
	
}

	
	
	/*
	@PostMapping("register")
	public Status registerUser(@Validated @RequestBody User newUser) {
		List<User> users = userService.getAll();
		System.out.println("New user: " + newUser.toString());
		for (User user : users) {
			System.out.println("Registered user: " + newUser.toString());
			if (user.equals(newUser)) {
				System.out.println("User Already exists!");
				return Status.USER_ALREADY_EXISTS;
			}
		}
		userService.create(newUser);
		return Status.SUCCESS;
	}

	@PostMapping("login")
	public Status loginUser(@Validated @RequestBody User user) {
		List<User> users = userService.getAll();
		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(true);
				userService.create(user);
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

	@PostMapping("logout")
	public Status logUserOut(@Validated @RequestBody User user) {
		List<User> users = userService.getAll();
		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(false);
				userService.create(user);
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

	@PostMapping()
	public User save(@RequestBody User user) {

		return userService.create(user);
	}

	@DeleteMapping("{id}")
	public Status delete(@PathVariable String id) {
		this.userService.deleteById(id);
		return Status.SUCCESS;

	}

	@GetMapping()
	public List<User> getALL() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public User getbyId(@PathVariable String id) {
		return this.userService.getById(id);
	}

	@GetMapping("/nom/{nom}")
	public List<User> findByNom(@PathVariable String nom) {
		return this.userService.findByNom(nom);
	}


	@PatchMapping()
	public User update(@RequestBody User film) {
		return this.userService.update(film);

	}
	*/
	

	
	/*
	 * @GetMapping("/nom/{nom}") public List<User> findByNomLike(@PathVariable
	 * String nom) { return this.userService.findByNomLike(nom) ; }
	 */
	
	


