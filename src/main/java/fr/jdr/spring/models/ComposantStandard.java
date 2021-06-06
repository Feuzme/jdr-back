package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class ComposantStandard {

	@Id
	@Getter @Setter
	private String id;
	
	@Getter @Setter
	private String nom;
	
	public ComposantStandard(String nom) {
		super();
		this.nom = nom;
	}
	
}
