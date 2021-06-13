package fr.jdr.spring.services.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.jdr.spring.dto.sheet.ModelSheetDto;
import fr.jdr.spring.dto.sheet.UpdateModelSheetDto;
import fr.jdr.spring.models.ModelSheet;
import fr.jdr.spring.repositories.ModelSheetRepository;
import fr.jdr.spring.services.GenericService;
import fr.jdr.spring.services.ModelSheetService;

public class ModelSheetServiceImpl implements GenericService<ModelSheet> {
	
	@Autowired
	private ModelSheetRepository repository;

	@Override
	public List<ModelSheet> getAll() {
		return this.repository.findAll();
	}

	@Override
	public ModelSheet getById(String id) {
		return this.repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public ModelSheet create(ModelSheet entity) {
		return this.repository.save(entity);
	}

	
	@Override
	public ModelSheet update(ModelSheet entity) {
		ModelSheet modelSheet = this.repository.findById(entity.getId())
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		if(entity.getIsPublic() != null)
			modelSheet.setIsPublic(entity.getIsPublic());
		if(entity.getComposants() != null)
			modelSheet.setComposants(entity.getComposants());
		if(entity.getGameType() != null)
			modelSheet.setGameType(entity.getGameType());
		if(entity.getName() != null)
			modelSheet.setName(entity.getName());
		if (entity.getUser() != null)
			modelSheet.setUser(entity.getUser());
		
		return this.repository.save(modelSheet);
	}

	@Override
	public void delete(ModelSheet entity) {
		if(this.repository.existsById(entity.getId()))
			this.repository.deleteById(entity.getId());
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}	
	
	
//	private ObjectMapper mapper;
//	
//	public ModelSheetServiceImpl(ModelSheetRepo repo, ObjectMapper mapper) {
//		this.repository = repo;
//		this.mapper = mapper;
//	}
//	
//	@Override
//	public List<ModelSheetDto> getAll() {
//		List<ModelSheet> modelSheets = this.repository.findAll();
//		
//		return modelSheets.stream().map(modelSheet -> {
//			return this.mapper.convertValue(modelSheet, ModelSheetDto.class);
//		}).collect(Collectors.toList());				 
//	}
//
//	@Override
//	public ModelSheetDto getById(String id) {
//		ModelSheet modelSheet = this.repository.findById(id)
//				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
//		
//		return this.mapper.convertValue(modelSheet, ModelSheetDto.class);
//	}
//
//	@Override
//	public ModelSheetDto create(ModelSheetDto dto) {
//		checkCreation(dto);
//		ModelSheet modelSheet = this.mapper.convertValue(dto, ModelSheet.class);
//		
//		modelSheet.setName(dto.getName());
//		modelSheet.setUser(dto.getUser());
//		modelSheet.setIsPublic(dto.getIsPublic());
//		modelSheet.setComposants(dto.getComposants());
//		
//		ModelSheet result = this.repository.save(modelSheet);
//		
//		return this.mapper.convertValue(result, ModelSheetDto.class);
//	}
//	
//	/**
//	 * verifie que toues les infos sont là pour la création de ModelSheet
//	 * 
//	 * @param dto
//	 */
//	private void checkCreation(ModelSheetDto dto) {
//		if(dto.getName()== null
//				|| dto.getUser() == null
//				|| dto.getGameType() == null
//				|| dto.getComposants() == null) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@Override
//	public ModelSheetDto update(UpdateModelSheetDto dto) {
//		ModelSheet modelSheet = this.repository.findById(dto.getId())
//				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
//		
//		if(dto.getIsPublic() != null)
//			modelSheet.setIsPublic(dto.getIsPublic());
//		if(dto.getGameType() != null)
//			modelSheet.setGameType(dto.getGameType());
//		if(dto.getName() != null)
//			modelSheet.setName(dto.getName());
//		if(dto.getComposants()!= null)
//			modelSheet.setComposants(dto.getComposants());
//		
//		ModelSheet result = this.repository.save(modelSheet);
//		
//		return this.mapper.convertValue(result, ModelSheetDto.class);
//	}
//	
//
//	@Override
//	public void deleteById(String id) {
//		if(this.repository.existsById(id))
//			this.repository.deleteById(id);
//		else
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//	}

	

}
