package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class ComposantEdit {

	@Id
	@Getter @Setter
	private String id;
	
	@Getter @Setter
	private String nom;
	
	@DBRef
	@Getter @Setter
	private ComposantStandard composantStandard;
	
	@DBRef
	@Getter @Setter
	private User user;
	
	public ComposantEdit(String nom, ComposantStandard composantStandard, User user) {
		super();
		this.nom = nom;
		this.composantStandard = composantStandard;
		this.user = user;
	}
}
