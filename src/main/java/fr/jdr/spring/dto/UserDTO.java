package fr.jdr.spring.dto;

import java.time.LocalDateTime;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	
	private String id;
	private String email;
	private String nom;
	private String password;
	private String avatar;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	

}
