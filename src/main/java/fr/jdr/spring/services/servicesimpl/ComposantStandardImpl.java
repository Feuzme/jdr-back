package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.jdr.spring.models.ComposantStandard;
import fr.jdr.spring.repositories.ComposantStandardRepository;
import fr.jdr.spring.services.GenericService;

public class ComposantStandardImpl implements GenericService<ComposantStandard>{

	@Autowired
	private ComposantStandardRepository composantStandardRepository;
	
	@Override
	public List<ComposantStandard> getAll() {
		return this.composantStandardRepository.findAll();
	}

	@Override
	public ComposantStandard getById(String id) {
		return this.composantStandardRepository.findById(id).get();
	}

	@Override
	public ComposantStandard create(ComposantStandard entity) {
		return this.composantStandardRepository.save(entity);
	}

	@Override
	public ComposantStandard update(ComposantStandard entity) {
		return this.composantStandardRepository.save(entity);
	}

	@Override
	public void delete(ComposantStandard entity) {
		this.composantStandardRepository.delete(entity);
	}

}
