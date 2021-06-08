package fr.jdr.spring.services;

import java.util.List;

import fr.jdr.spring.dto.sheet.ModelSheetDto;
import fr.jdr.spring.dto.sheet.UpdateModelSheetDto;

public interface ModelSheetService {
	/**
	 * retourne la liste de toute les ModelSheet en BDD
	 * @return
	 */
	public List<ModelSheetDto> getAll();
	
	/**
	 * retourne une ModelSheet en fonction de sont ID
	 * @param id
	 * @return
	 */
	public ModelSheetDto getById(String id);
	
	/**
	 * Creer une ModelSheet et retourne le resultat de la sauvegarde
	 * @param dto
	 * @return
	 */
	public ModelSheetDto create(ModelSheetDto dto);
	
	/**
	 * permet de modifier sa ModelSheet
	 * @param dto
	 * @return
	 */
	public ModelSheetDto update(UpdateModelSheetDto dto);
	
	/**
	 * supprime un ModelSheet en fonction de son ID
	 * @param id
	 */
	public void deleteById(String id);
}
