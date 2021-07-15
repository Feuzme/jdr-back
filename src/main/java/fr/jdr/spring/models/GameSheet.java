package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class GameSheet {
	@Id
	private String id;
	private ModelSheet sheet;
	private Object orginalCharacterInfos;
	private Object characterInfos;
	@DBRef
	private User user; 
	
}
