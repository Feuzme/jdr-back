package fr.jdr.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreationUserDTO {
	
	private String nom;
	private String email;
	private String password;
	private String avatar;

	

}
