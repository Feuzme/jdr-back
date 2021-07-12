package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.models.BasePlugin;
import fr.jdr.spring.services.GenericService;

@RestController
@RequestMapping("base_plugins")
@CrossOrigin
public class BasePluginController {

	@Autowired
	private GenericService<BasePlugin> basePluginService;
	
	@GetMapping()
	public List<BasePlugin> getAll() {
		return this.basePluginService.getAll();
	}
	
	@PostMapping()
	public BasePlugin create(@RequestBody BasePlugin entity) {
		return this.basePluginService.create(entity);
	}
	
	@GetMapping("{id}")
	public BasePlugin getById(@PathVariable String id) {
		return this.basePluginService.getById(id);
	}
	
	@PatchMapping()
	public BasePlugin update(@RequestBody BasePlugin entity) {
		return this.basePluginService.update(entity);
	}

	@DeleteMapping()
	public void delete(@RequestBody BasePlugin entity) {
		this.basePluginService.delete(entity);
	}
}
