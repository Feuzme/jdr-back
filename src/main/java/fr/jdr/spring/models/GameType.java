package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class GameType {
	@Id
	private String id;
	
	private String nom;
	
	private String logo;
}
