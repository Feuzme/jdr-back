package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.models.Game;
import fr.jdr.spring.models.User;
import fr.jdr.spring.services.servicesimpl.GameServiceImpl;

@RestController
@RequestMapping("games")
@CrossOrigin
public class GameController {
	
	@Autowired
	private GameServiceImpl gameService;
	
	@GetMapping()
	public List<Game> getAll(){
		return this.gameService.getAll();
	}
	
	@GetMapping("{id}")
	public Game getById(@PathVariable String id) {
		return this.gameService.getById(id);
	}
	
	@GetMapping("mj/{id}")
	public List<Game> getAllByMjUser(@PathVariable String id) {
		return this.gameService.findAllByMj(id);
	}
	
	@GetMapping("players/{id}")
	public List<Game> getAllByListPlayers(@PathVariable String id) {
		return this.gameService.findAllByPlayers(id);
	}

	@PostMapping("addPlayer/{gameId}/{newPlayerId}")
	public Game addNewPlayer(@PathVariable String gameId, @PathVariable String newPlayerId) {
		return this.gameService.addPlayers(gameId, newPlayerId);
	}
	
	@PostMapping()
	public Game create(@RequestBody Game game) {
		return this.gameService.create(game);
	}
	
	@PatchMapping()
	public Game update(@RequestBody Game game) {
		return this.gameService.update(game);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Game game) {
		this.gameService.delete(game);
	}
}
