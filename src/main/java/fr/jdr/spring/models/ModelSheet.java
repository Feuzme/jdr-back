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
	@DBRef
	private User user;
	private Boolean isPublic;
	@DBRef
	private GameType gameType;
	@DBRef
	private List<BasePluginEdit> composants;
		
}
