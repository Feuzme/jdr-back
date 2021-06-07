package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Session {
	@Id
	private String id;
	
	@DBRef
	private Game game;
	
	private Integer episode_num;
	
	private String resume;
	
	private String lieu;
}
