package fr.jdr.spring.services.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jdr.spring.dto.sheet.GameSheetCreationDto;
import fr.jdr.spring.dto.sheet.GameSheetDto;
import fr.jdr.spring.dto.sheet.UpdateGameSheetCharacInfosDto;
import fr.jdr.spring.models.GameSheet;
import fr.jdr.spring.repositories.GameSheetRepository;
import fr.jdr.spring.services.GameSheetService;
import fr.jdr.spring.services.GenericService;

public class GameSheetServiceImpl implements GenericService<GameSheet> {

	@Autowired
	private GameSheetRepository repository;

	@Override
	public List<GameSheet> getAll() {
		return this.repository.findAll();
	}

	@Override
	public GameSheet getById(String id) {
		return this.repository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public GameSheet create(GameSheet entity) {
		return this.repository.save(entity);
	}

	@Override
	public GameSheet update(GameSheet entity) {
		GameSheet gameSheet = this.repository.findById(entity.getId())
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		if(entity.getCharacterInfos() != null)
			gameSheet.setCharacterInfos(entity.getCharacterInfos());
		if(entity.getOrginalCharacterInfos() != null)
			gameSheet.setOrginalCharacterInfos(entity.getOrginalCharacterInfos());
		
		return this.repository.save(gameSheet);
	}

	@Override
	public void delete(GameSheet entity) {
		this.repository.deleteById(entity.getId());
		
	}	
	
	
	
//	private ObjectMapper mapper;

//	/**
//	 * Constructeur pour initialiser le mapper et le repo en utilisant les bean
//	 * 
//	 * @param repo
//	 * @param mapper
//	 */
//	public GameSheetServiceImpl(GameSheetRepository repo, ObjectMapper mapper) {
//		this.mapper = mapper;
//		this.repository = repo;
//	}
//
//	@Override
//	public List<GameSheetCreationDto> getAll() {
//		List<GameSheet> gameSheets = this.repository.findAll();
//		// converti chaque element de la list en GameSheetDto gra^ce à stream().map()
//		return gameSheets.stream().map(gameSheet -> {
//			return this.mapper.convertValue(gameSheet, GameSheetCreationDto.class);
//		}).collect(Collectors.toList());
//	}
//
//	@Override
//	public GameSheetDto getById(String id) {
//		// cherche dans la bdd sinon renvoie 404
//		GameSheet gamesheet = this.repository.findById(id)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//		// retourne la gamesheet trouvée en la convertissant en GameSheetDto
//		return this.mapper.convertValue(gamesheet, GameSheetDto.class);
//	}
//
//	@Override
//	public GameSheetCreationDto create(GameSheetCreationDto dto) {
//		checkSheetCreation(dto);
//		
//		GameSheet gameSheet = this.mapper.convertValue(dto, GameSheet.class);		
//
//		// A la creation les infos perso sont = aux infos d'origine
//		gameSheet.setCharacterInfos(gameSheet.getOrginalCharacterInfos());
//
//		gameSheet.setOrginalCharacterInfos(dto.getOriginCharacInfos());
//		gameSheet.setSheet(dto.getModel());
//		gameSheet.setUser(dto.getUser());
//
//		GameSheet result = this.repository.save(gameSheet);
//
//		// retourne le resultat et le converti en dto pour l'envoie au client
//		return this.mapper.convertValue(result, GameSheetCreationDto.class);
//	}
//
//	/**
//	 * verifie que toues les infos sont là pour la création de GameSheet
//	 * 
//	 * @param dto
//	 */
//	private void checkSheetCreation(GameSheetCreationDto dto) {
//		if (dto.getModel() == null || dto.getUser() == null || dto.getOriginCharacInfos() == null) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//		}
//
//	}
//
//	@Override
//	public GameSheetDto updateCharacInfos(UpdateGameSheetCharacInfosDto dto) {
//		// recupère l'objet en BDD
//		GameSheet entity = this.repository.findById(dto.getId())
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//		//met à jour le champ CharacInfos s'il est bien renseigné
//		if (dto.getCharacInfo() != null)
//			entity.setCharacterInfos(dto.getCharacInfo());
//
//		//save en bdd
//		GameSheet result = this.repository.save(entity);
//
//		//retourne le resultat en le convertissant
//		return this.mapper.convertValue(result, GameSheetDto.class);
//	}
//
//	
//	@Override
//	public void deleteById(String id) {
//		//verifie existe puis delete
//		if (this.repository.existsById(id))
//			this.repository.deleteById(id);
//		else
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//	}
}
