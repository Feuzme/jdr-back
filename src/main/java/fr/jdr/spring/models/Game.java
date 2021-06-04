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
	
	private int nb_joueur;
	
	private String trame;
	
	private String logo;
	
	private Boolean is_public;
	
	private String status;
	
	@DBRef
	private User mj_user;
	
	@DBRef
	private GameType game_type;
}
