package fr.jdr.spring.models;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {
	
	@Id
	private String id;
	
	private String nom;
	private String email;
	private String password;
	private String acatar;
	private String bio;
	private String ville;
	
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	

	public enum Status {
	    SUCCESS,
	    USER_ALREADY_EXISTS,
	    FAILURE
	}
	
}
