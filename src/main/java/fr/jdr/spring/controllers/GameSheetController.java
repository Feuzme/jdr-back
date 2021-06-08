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
import fr.jdr.spring.services.GameSheetService;

@CrossOrigin
@RestController
@RequestMapping("gamesheets")
public class GameSheetController {
	
	@Autowired
	private GameSheetService service;
	
	@GetMapping("")
	public List<GameSheetCreationDto> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("{id}")
	public GameSheetDto findById(@PathVariable String id) {
		return this.service.getById(id);
	}
	
	@PostMapping()
	public GameSheetCreationDto create(@RequestBody GameSheetCreationDto dto) {
		return this.service.create(dto);
	}
	
	@PutMapping("{id}/characinfosupdate")
	public GameSheetDto updateCharacInfo(@RequestBody UpdateGameSheetCharacInfosDto dto) {
		return this.service.updateCharacInfos(dto);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable String id) {
		this.service.deleteById(id);
	}

}