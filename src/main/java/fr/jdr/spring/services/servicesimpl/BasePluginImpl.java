package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.jdr.spring.models.BasePlugin;
import fr.jdr.spring.repositories.BasePluginRepository;
import fr.jdr.spring.services.GenericService;

public class BasePluginImpl implements GenericService<BasePlugin>{

	@Autowired
	private BasePluginRepository basePluginRepository;
	
	@Override
	public List<BasePlugin> getAll() {
		return this.basePluginRepository.findAll();
	}

	@Override
	public BasePlugin getById(String id) {
		return this.basePluginRepository.findById(id).get();
	}

	@Override
	public BasePlugin create(BasePlugin entity) {
		return this.basePluginRepository.save(entity);
	}

	@Override
	public BasePlugin update(BasePlugin entity) {
		return this.basePluginRepository.save(entity);
	}

	@Override
	public void delete(BasePlugin entity) {
		this.basePluginRepository.delete(entity);
	}

}