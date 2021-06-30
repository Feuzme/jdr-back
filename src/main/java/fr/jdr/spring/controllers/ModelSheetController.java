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

import fr.jdr.spring.models.ModelSheet;
import fr.jdr.spring.services.GenericService;

@CrossOrigin
@RestController
@RequestMapping("modelsheets")
public class ModelSheetController {
	@Autowired
	private GenericService<ModelSheet> service;
	
	@GetMapping("")
	public List<ModelSheet> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("{id}")
	public ModelSheet getById(@PathVariable String id) {
		return this.service.getById(id);
	}
	
	@PostMapping("")
	public ModelSheet create(@RequestBody ModelSheet entity) {
		return this.service.create(entity);
	}
	
	@PatchMapping("")
	public ModelSheet update(ModelSheet entity) {
		return this.service.update(entity);
	}
	
	@DeleteMapping("")
	public void delete(@RequestBody ModelSheet entity) {
		this.service.delete(entity);
	}
}
