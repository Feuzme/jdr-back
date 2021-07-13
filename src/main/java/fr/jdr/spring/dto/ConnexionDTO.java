package fr.jdr.spring.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class ConnexionDTO {

	private String nameOrEmail;
	private String password;

}
