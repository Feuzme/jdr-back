package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.models.ComposantEdit;
import fr.jdr.spring.services.GenericService;

@RestController
@RequestMapping("edit_composants")
public class ComposantEditController {
	
	@Autowired
	private GenericService<ComposantEdit> composantEditService;
	
	@GetMapping()
	public List<ComposantEdit> getAll() {
		return this.composantEditService.getAll();
	}
	
	@PostMapping()
	public ComposantEdit create(@RequestBody ComposantEdit cinema) {
		return this.composantEditService.create(cinema);
	}
	
	@GetMapping("{id}")
	public ComposantEdit getById(@PathVariable String id) {
		return this.composantEditService.getById(id);
	}
	
	@PutMapping()
	public ComposantEdit update(@RequestBody ComposantEdit cinema) {
		return this.composantEditService.update(cinema);
	}

	@DeleteMapping()
	public void delete(@RequestBody ComposantEdit cinema) {
		this.composantEditService.delete(cinema);
	}
}
