package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class PlugIn {
	@Id
	private String id;
	private String nom;
	private String auteur;
	@DBRef
	private GameType gameType;
	private String config;
	private PositionSize positionSize;
}
