package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import fr.jdr.spring.models.Game;
import fr.jdr.spring.models.GameType;
import fr.jdr.spring.repositories.GameTypeRepository;
import fr.jdr.spring.services.GenericService;

public class GameTypeServiceImpl implements GenericService<GameType> {
	
	@Autowired
	private GameTypeRepository repository;
	
	@Override
	public List<GameType> getAll() {
		return this.repository.findAll();
	}

	@Override
	public GameType getById(String id) {
		return this.repository.findById(id).get();
	}

	@Override
	public GameType create(GameType game) {
		return this.repository.save(game);
	}

	@Override
	public GameType update(GameType game) {
		GameType gameType = this.repository.findById(game.getId())
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

		if(game.getLogo() != null)
			gameType.setLogo(game.getLogo());
		if(game.getNom() != null)
			gameType.setNom(game.getNom());
		
		return this.repository.save(gameType);
	}

	@Override
	public void delete(GameType game) {
		this.repository.delete(game);	
	}

}
