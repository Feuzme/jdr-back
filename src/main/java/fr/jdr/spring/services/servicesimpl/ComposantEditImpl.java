package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.jdr.spring.models.ComposantEdit;
import fr.jdr.spring.repositories.ComposantEditRepository;
import fr.jdr.spring.services.GenericService;

public class ComposantEditImpl implements GenericService<ComposantEdit> {

	@Autowired
	private ComposantEditRepository composantEditRepository;
	
	@Override
	public List<ComposantEdit> getAll() {
		return this.composantEditRepository.findAll();
	}

	@Override
	public ComposantEdit getById(String id) {
		return this.composantEditRepository.findById(id).get();
	}

	@Override
	public ComposantEdit create(ComposantEdit entity) {
		return this.composantEditRepository.save(entity);
	}

	@Override
	public ComposantEdit update(ComposantEdit entity) {
		return this.composantEditRepository.save(entity);
	}

	@Override
	public void delete(ComposantEdit entity) {
		this.composantEditRepository.delete(entity);
	}

}
