package fr.jdr.spring.models;

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
	private GameName gameName;
		
}
