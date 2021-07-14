package fr.jdr.spring.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.jdr.spring.models.Game;
import fr.jdr.spring.models.User;
import fr.jdr.spring.repositories.GameRepository;
import fr.jdr.spring.services.GenericService;
import fr.jdr.spring.services.UserService;

public class GameServiceImpl implements GenericService<Game> {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Game> getAll() {
		return this.gameRepository.findAll();
	}

	@Override
	public Game getById(String gameId) {
		return this.gameRepository.findById(gameId).get();
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
	
	public List<Game> findAllByMj(String gameId){
		return this.gameRepository.findByMjUser(gameId);
	}
	
	public List<Game> findAllByPlayers(String gameId){
		return this.gameRepository.findByListPlayers(gameId);
	}
	
	public Game addPlayers(String gameId, String idNewPlayer) {
		Game entity = this.getById(gameId);
		User entityPlayer = userService.findById(idNewPlayer);
		entity.getListPlayers().add(entityPlayer);
		return this.gameRepository.save(entity);
	}
}
