package fr.jdr.spring.services.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jdr.spring.dto.sheet.GameSheetDto;
import fr.jdr.spring.models.GameSheet;
import fr.jdr.spring.repositories.GameSheetRepository;
import fr.jdr.spring.services.GameSheetService;

public class GameSheetServiceImpl implements GameSheetService {
	
	private GameSheetRepository repository;
	private ObjectMapper mapper;
	
	public GameSheetServiceImpl(GameSheetRepository repo, ObjectMapper mapper) {
		this.mapper = mapper;
		this.repository = repo;
	}
	
	@Override
	public List<GameSheetDto> getAll() {	
		List<GameSheet> gameSheets = this.repository.findAll();
		
		return gameSheets.stream().map(gameSheet -> {
			return this.mapper.convertValue(gameSheet, GameSheetDto.class);
		}).collect(Collectors.toList());
	}	

	@Override
	public GameSheetDto getById(String id) {
		GameSheet gamesheet = this.repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		return this.mapper.convertValue(gamesheet, GameSheetDto.class);
	}

	@Override
	public GameSheetDto create(GameSheetDto entity) {
		GameSheet gameSheet = this.mapper.convertValue(entity, GameSheet.class);
		
		gameSheet.setCharacterInfos(entity.getCharacInfos());
		gameSheet.setOrginalCharacterInfos(entity.getCharacInfos());
		gameSheet.setSheet(entity.getModel());
		gameSheet.setUser(entity.getUser());
		
		GameSheet result = this.repository.save(gameSheet);
				
		return this.mapper.convertValue(result, GameSheetDto.class);
	}
	

	@Override
	public GameSheetDto update(GameSheetDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(GameSheetDto entity) {
		// TODO Auto-generated method stub
		
	}



}
