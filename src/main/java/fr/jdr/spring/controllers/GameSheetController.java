package fr.jdr.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jdr.spring.dto.sheet.GameSheetDto;
import fr.jdr.spring.services.GameSheetService;

@CrossOrigin
@RestController
@RequestMapping("gamesheets")
public class GameSheetController {
	
	@Autowired
	private GameSheetService service;
	
	@GetMapping("")
	public List<GameSheetDto> findAll() {
		return this.service.getAll();
	}
}
