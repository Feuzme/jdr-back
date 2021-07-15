package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.jdr.spring.models.Creneau;
import fr.jdr.spring.models.Game;
import fr.jdr.spring.repositories.CreneauRepository;
import fr.jdr.spring.services.GenericService;

public class CreneauServiceImpl implements GenericService<Creneau> {
	
	@Autowired
	private CreneauRepository creneauRepository;
	
	@Override
	public List<Creneau> getAll() {
		return this.creneauRepository.findAll();
	}

	@Override
	public Creneau getById(String id) {
		return this.creneauRepository.findById(id).get();
	}

	@Override
	public Creneau create(Creneau creneau) {
		return this.creneauRepository.save(creneau);
	}

	@Override
	public Creneau update(Creneau creneau) {
		return this.creneauRepository.save(creneau);
	}

	@Override
	public void delete(Creneau creneau) {
		this.creneauRepository.delete(creneau);	
	}
	
	public List<Creneau> findAllByGame(String gameId){
		return this.creneauRepository.findByGame(gameId);
	}
}
