package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.UserRepository;
import fr.jdr.spring.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository ;

	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll() ;
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}
	
	public List<User> findByNomLike(String nom){
		return this.userRepository.findByNom(nom);
		
	}
	
	public List<User> findByNom(String nom){
		return this.userRepository.findByNom(nom);
	}

	
	

	@Override
	public User create(User t) {
		// TODO Auto-generated method stub
		return userRepository.save(t);
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return userRepository.save(t);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}
	


}
