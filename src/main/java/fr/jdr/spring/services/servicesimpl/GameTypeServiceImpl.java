package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import fr.jdr.spring.models.GameType;
import fr.jdr.spring.repositories.GameTypeRepository;
import fr.jdr.spring.services.GenericService;

public class GameTypeServiceImpl implements GenericService<GameType> {
	private GameTypeRepository repository;
	@Override
	public List<GameType> getAll() {
		return this.repository.findAll();
	}

	@Override
	public GameType getById(String id) {
		return this.repository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public GameType create(GameType entity) {
		return this.repository.save(entity);
	}

	@Override
	public GameType update(GameType entity) {
		GameType gameType = this.repository.findById(entity.getId())
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		if(entity.getLogo() != null)
			gameType.setLogo(entity.getLogo());
		if(entity.getNom() != null)
			gameType.setNom(entity.getNom());
		
		return this.repository.save(gameType);
	}

	@Override
	public void delete(GameType entity) {
		if(this.repository.existsById(entity.getId()))
			this.repository.deleteById(entity.getId());
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
