package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.jdr.spring.models.BasePluginEdit;
import fr.jdr.spring.repositories.BasePluginEditRepository;
import fr.jdr.spring.services.GenericService;

public class BasePluginEditImpl implements GenericService<BasePluginEdit> {

	@Autowired
	private BasePluginEditRepository basePluginEditRepository;
	
	@Override
	public List<BasePluginEdit> getAll() {
		return this.basePluginEditRepository.findAll();
	}

	@Override
	public BasePluginEdit getById(String id) {
		return this.basePluginEditRepository.findById(id).get();
	}

	@Override
	public BasePluginEdit create(BasePluginEdit entity) {
		return this.basePluginEditRepository.save(entity);
	}

	@Override
	public BasePluginEdit update(BasePluginEdit entity) {
		return this.basePluginEditRepository.save(entity);
	}

	@Override
	public void delete(BasePluginEdit entity) {
		this.basePluginEditRepository.delete(entity);
	}

}
