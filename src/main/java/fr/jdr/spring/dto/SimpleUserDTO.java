package fr.jdr.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleUserDTO {
	
	private String id;
	private String nom;
	private String email;

}
