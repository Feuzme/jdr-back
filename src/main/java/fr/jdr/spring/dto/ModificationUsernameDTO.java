package fr.jdr.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModificationUsernameDTO {

	
	private String id;
	private String nom;
	private String email;
	private String bio;
	private String ville;
	private String avatar;
}
