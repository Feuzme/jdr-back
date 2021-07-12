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

import fr.jdr.spring.models.PlugIn;
import fr.jdr.spring.services.GenericService;

@CrossOrigin
@RestController
@RequestMapping("plugins")
public class PlugInController {
	@Autowired
	private GenericService<PlugIn> service;

	@GetMapping("")
	public List<PlugIn> getAll() {
		return service.getAll();
	}

	@GetMapping("{id}")
	public PlugIn getById(@PathVariable String id) {
		return service.getById(id);
	}

	@PostMapping("")
	public PlugIn create(@RequestBody PlugIn entity) {
		return service.create(entity);
	}

	@PatchMapping("")
	public PlugIn update(@RequestBody PlugIn entity) {
		return service.update(entity);
	}

	@DeleteMapping("")
	public void delete(@RequestBody PlugIn entity) {
		service.delete(entity);
	}
	
	
}
