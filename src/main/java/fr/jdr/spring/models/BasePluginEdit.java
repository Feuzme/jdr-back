package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
public class BasePluginEdit {

	@Id
	@Getter @Setter
	private String id;
	
	@Getter @Setter
	private String nom;
	
	@DBRef
	@Getter @Setter
	private BasePlugin composantStandard;
	
	@DBRef
	@Getter @Setter
	private User user;
	
	public BasePluginEdit(String nom, BasePlugin composantStandard, User user) {
		super();
		this.nom = nom;
		this.composantStandard = composantStandard;
		this.user = user;
	}
}
