package fr.jdr.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModificationUserPasswordDTO {

	
	private String id;
	private String username;
	private String email;
}
