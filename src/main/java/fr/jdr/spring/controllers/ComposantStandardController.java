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

import fr.jdr.spring.models.ComposantStandard;
import fr.jdr.spring.services.GenericService;

@RestController
@RequestMapping("standard_composants")
public class ComposantStandardController {

	@Autowired
	private GenericService<ComposantStandard> composantStandardService;
	
	@GetMapping()
	public List<ComposantStandard> getAll() {
		return this.composantStandardService.getAll();
	}
	
	@PostMapping()
	public ComposantStandard create(@RequestBody ComposantStandard cinema) {
		return this.composantStandardService.create(cinema);
	}
	
	@GetMapping("{id}")
	public ComposantStandard getById(@PathVariable String id) {
		return this.composantStandardService.getById(id);
	}
	
	@PutMapping()
	public ComposantStandard update(@RequestBody ComposantStandard cinema) {
		return this.composantStandardService.update(cinema);
	}

	@DeleteMapping()
	public void delete(@RequestBody ComposantStandard cinema) {
		this.composantStandardService.delete(cinema);
	}
}
