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

}
