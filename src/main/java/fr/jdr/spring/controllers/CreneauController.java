package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.models.Creneau;
import fr.jdr.spring.services.GenericService;

@RestController
@RequestMapping("creneaux")
public class CreneauController {
	
	@Autowired
	private GenericService<Creneau> creneauService;
	
	@GetMapping
	public List<Creneau> getAll(){
		return this.creneauService.getAll();
	}
	
	@GetMapping("{id}")
	public Creneau getById(@PathVariable String id) {
		return this.creneauService.getById(id);
	}
	
	@PostMapping()
	public Creneau create(@RequestBody Creneau creneau) {
		return this.creneauService.create(creneau);
	}
	
	@PatchMapping()
	public Creneau update(@RequestBody Creneau creneau) {
		return this.creneauService.update(creneau);
	}  

	@DeleteMapping()
	public void delete(@RequestBody Creneau creneau) {
		this.creneauService.delete(creneau);
	}
}
