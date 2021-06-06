package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {
	
	@Id
	private Long id;
	
	private String nom;
	private String email;
	private String password;
	private String acatar;
	private String bio;
	private String ville;
	

}
