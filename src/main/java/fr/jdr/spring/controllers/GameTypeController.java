package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.models.GameType;
import fr.jdr.spring.services.GenericService;

@CrossOrigin
@RestController
@RequestMapping("gametypes")
public class GameTypeController {
	@Autowired
	private GenericService<GameType> service;
	
	@GetMapping("")
	public List<GameType> getAll(){
		return this.service.getAll();
	}
	
	@GetMapping("{id}")
	public GameType getById(@PathVariable String id) {
		return this.service.getById(id);
	}
	
	@PatchMapping("")
	public GameType update(@RequestBody GameType entity) {
		return this.service.update(entity);
	}
	
	@DeleteMapping("")
	public void deleteById(@RequestBody GameType entity) {
		this.service.delete(entity);
	}
}
