package fr.jdr.spring.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleUserDTO {
	
	private String id;
	private String nom;
	private String email;
	private String avatar;
	private String bio;
	private String ville;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;

}
