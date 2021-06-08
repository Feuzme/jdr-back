package fr.jdr.spring.services;

import java.util.List;

import fr.jdr.spring.dto.sheet.GameSheetDto;

public interface GameSheetService {
	public List<GameSheetDto> getAll();
	
	public GameSheetDto getById(String id);
	
	public GameSheetDto create(GameSheetDto entity);
	
	public GameSheetDto update(GameSheetDto entity);
	
	public void deleteById(String id);
}
