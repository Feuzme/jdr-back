package fr.jdr.spring.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ModelSheet {
	@Id
	private String id;
	
	private String name;
	
	private Boolean isPublic;
	
	@DBRef
	private User user;
	
	@DBRef
	private GameType gameType;
	
	@DBRef
	private List<PlugIn> composants;		
}
