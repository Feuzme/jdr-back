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

import fr.jdr.spring.dto.sheet.ModelSheetDto;
import fr.jdr.spring.dto.sheet.UpdateModelSheetDto;
import fr.jdr.spring.services.ModelSheetService;

@CrossOrigin
@RestController
@RequestMapping("modelsheets")
public class ModelSheetController {
	@Autowired
	private ModelSheetService service;
	
	@GetMapping("")
	public List<ModelSheetDto> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("{id}")
	public ModelSheetDto getById(@PathVariable String id) {
		return this.service.getById(id);
	}
	
	@PostMapping("")
	public ModelSheetDto create(@RequestBody ModelSheetDto dto) {
		return this.service.create(dto);
	}
	
	@PatchMapping("{id}")
	public ModelSheetDto update(@PathVariable String id, @RequestBody UpdateModelSheetDto dto) {
		return this.service.update(dto);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		this.service.deleteById(id);
	}
}
