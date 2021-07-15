package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.models.BasePluginEdit;
import fr.jdr.spring.services.GenericService;

@RestController
@RequestMapping("edit_composants")
public class BasePlugintEditController {
	
	@Autowired
	private GenericService<BasePluginEdit> basePluginEditService;
	
	@GetMapping()
	public List<BasePluginEdit> getAll() {
		return this.basePluginEditService.getAll();
	}
	
	@PostMapping()
	public BasePluginEdit create(@RequestBody BasePluginEdit entity) {
		return this.basePluginEditService.create(entity);
	}
	
	@GetMapping("{id}")
	public BasePluginEdit getById(@PathVariable String id) {
		return this.basePluginEditService.getById(id);
	}
	
	@PatchMapping()
	public BasePluginEdit update(@RequestBody BasePluginEdit entity) {
		return this.basePluginEditService.update(entity);
	}

	@DeleteMapping()
	public void delete(@RequestBody BasePluginEdit entity) {
		this.basePluginEditService.delete(entity);
	}
}
