package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class BasePlugin {

	@Id
	@Getter @Setter
	private String id;
	
	@Getter @Setter
	private String nom;
	
	@Getter @Setter
	private Object config;
	
	public BasePlugin(String nom, Object config) {
		super();
		this.nom = nom;
		this.config = config;
	}
	
}
