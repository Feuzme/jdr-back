package fr.jdr.spring.services;

import java.util.List;

import fr.jdr.spring.dto.sheet.GameSheetCreationDto;
import fr.jdr.spring.dto.sheet.UpdateGameSheetCharacInfosDto;

public interface GameSheetService {
	/**
	 * retourne la liste de toutes le gamesheet sous forme de GameSheetDto
	 */
	public List<GameSheetCreationDto> getAll();
	
	/**
	 * Retourne un GameSheetDto correspondant à l'id recherché
	 * @param id
	 * @return
	 */
	public GameSheetCreationDto getById(String id);
	
	/**
	 * permet mettre une GameSheet en base
	 * @param dto
	 * @return
	 */
	public GameSheetCreationDto create(GameSheetCreationDto dto);
	
	/**
	 * permet de mettre à jour les infos personnage d'une GameSheet
	 * @param dto
	 * @return
	 */
	public GameSheetCreationDto updateCharacInfos(UpdateGameSheetCharacInfosDto dto);
	
	/**
	 * supprime une fiche via son ID
	 * @param id
	 */
	public void deleteById(String id);
}
