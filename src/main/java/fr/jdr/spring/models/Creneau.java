package fr.jdr.spring.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Creneau {
	@Id
	private String id;
	
	private LocalDateTime date_Deb;
	
	private LocalDateTime date_Fin;
	
	private int frequence;
	
	private boolean prochaine_Session;
	
	@DBRef
	private User user;
	
	@DBRef
	private Session session;
}
