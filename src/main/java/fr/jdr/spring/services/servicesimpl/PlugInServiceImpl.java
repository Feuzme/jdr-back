package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import fr.jdr.spring.models.PlugIn;
import fr.jdr.spring.repositories.PlugInRepository;
import fr.jdr.spring.services.GenericService;

public class PlugInServiceImpl implements GenericService<PlugIn> {

	@Autowired
	private PlugInRepository repository;
	
	@Override
	public List<PlugIn> getAll() {
		return this.repository.findAll();
	}

	@Override
	public PlugIn getById(String id) {
		return this.repository.findById(id)
				.orElseThrow(
						()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public PlugIn create(PlugIn entity) {
		return this.repository.save(entity);
	}

	@Override
	public PlugIn update(PlugIn entity) {
		PlugIn plugIn = this.repository.findById(entity.getId())
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		if(entity.getNom() != null)
			plugIn.setNom(entity.getNom());
		if(entity.getAuteur() != null)
			plugIn.setAuteur(entity.getAuteur());
		if(entity.getConfig() != null)
			plugIn.setConfig(entity.getConfig());
		if(entity.getGameType() != null)
			plugIn.setGameType(entity.getGameType());	
		if(entity.getOrigin() != null)
			plugIn.setOrigin(entity.getOrigin());
		
		return this.repository.save(plugIn);
	}

	@Override
	public void delete(PlugIn entity) {
		if(this.repository.existsById(entity.getId()))
			this.repository.deleteById(entity.getId());
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);			
	}

}
