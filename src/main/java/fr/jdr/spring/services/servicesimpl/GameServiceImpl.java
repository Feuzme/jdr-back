package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.jdr.spring.models.Game;
import fr.jdr.spring.repositories.GameRepository;
import fr.jdr.spring.services.GenericService;

public class GameServiceImpl implements GenericService<Game> {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public List<Game> getAll() {
		return this.gameRepository.findAll();
	}

	@Override
	public Game getById(String id) {
		return this.gameRepository.findById(id).get();
	}

	@Override
	public Game create(Game game) {
		return this.gameRepository.save(game);
	}

	@Override
	public Game update(Game game) {
		return this.gameRepository.save(game);
	}

	@Override
	public void delete(Game game) {
		this.gameRepository.delete(game);	
	}
	
	public List<Game> findAllByMj(String id){
		return this.gameRepository.findByMjUserLike(id);
	}
}
