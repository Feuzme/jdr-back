package fr.jdr.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModificationPasswordDTO {

	
	private String id;
	private String username;
	private String email;
	private String password;
}
