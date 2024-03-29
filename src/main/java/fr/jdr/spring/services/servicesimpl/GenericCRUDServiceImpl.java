package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fr.jdr.spring.services.GenericCRUDService;


public class GenericCRUDServiceImpl<T> implements GenericCRUDService<T>{

	private MongoRepository<T, String> repository;
	
	public GenericCRUDServiceImpl(MongoRepository<T, String> repository) {
		this.repository = repository;
	}

	@Override
	public T findById(String id) {
		T entity = this.repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		return entity;
	}

	@Override
	public List<T> findAll() {
		return this.repository.findAll();
	}

	@Override
	public T save(T entity) {
		return this.repository.save(entity);
	}
	
	@Override
	public void deleteById(String id) {
		if(this.repository.existsById(id))
			this.repository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
