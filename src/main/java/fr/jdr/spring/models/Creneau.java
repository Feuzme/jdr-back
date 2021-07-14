package fr.jdr.spring.models;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Creneau {
	@Id
	private String id;
	
	private String dateDeb;
	
	private String dateFin;
	
	private boolean prochaineSession;
	
	@DBRef
	private User user;
	
	@DBRef
	@Lazy(true)
	private Game game;
}
