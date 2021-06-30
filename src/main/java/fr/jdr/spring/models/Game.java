package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Game {
	@Id
	private String id;
	
	private String nom;
	
	private Integer nbJoueur;
	
	private String trame;
	
	private String logo;
	
	private Boolean isPublic;
	
	private String status;
	
	@DBRef
	private User mjUser;
	
	@DBRef
	private GameType gameType;
}
