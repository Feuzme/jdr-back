package fr.jdr.spring.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleUserDto {
	private String id;
	private String pseudo;
}
