package fr.jdr.spring.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConnexionDTO {

	private String nom;
	private String password;
	private String email;
	
}
