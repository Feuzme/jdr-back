package fr.jdr.spring.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Game {
	@Id
	private String id;
	
	private String name;
	
	private Integer nbPlayers;
	
	private String story;
	
	private String logo;
	
	private Boolean isPublic;
	
	private String status;
	
	@DBRef
	private User mjUser;
	
	@DBRef
	private GameType gameType;
	
	private List<String> listPlayers;
}
