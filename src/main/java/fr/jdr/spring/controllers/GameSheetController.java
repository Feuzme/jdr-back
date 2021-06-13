package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.dto.sheet.GameSheetCreationDto;
import fr.jdr.spring.dto.sheet.GameSheetDto;
import fr.jdr.spring.dto.sheet.UpdateGameSheetCharacInfosDto;
import fr.jdr.spring.models.GameSheet;
import fr.jdr.spring.services.GameSheetService;
import fr.jdr.spring.services.GenericService;

@CrossOrigin
@RestController
@RequestMapping("gamesheets")
public class GameSheetController {
	
	@Autowired
	private GenericService<GameSheet> service;
	
	@GetMapping("")
	public List<GameSheet> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("{id}")
	public GameSheet findById(@PathVariable String id) {
		return this.service.getById(id);
	}
	
	@PostMapping()
	public GameSheet create(@RequestBody GameSheet entity) {
		return this.service.create(entity);
	}
	
	@PutMapping("{id}")
	public GameSheet update(@RequestBody GameSheet entity) {
		return this.service.update(entity);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@RequestBody GameSheet entity) {
		this.service.delete(entity);
	}

}
