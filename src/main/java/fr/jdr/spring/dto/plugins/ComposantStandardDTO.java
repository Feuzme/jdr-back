package fr.jdr.spring.dto.plugins;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComposantStandardDTO {
	private String id;
	private String nom;
	private Object config;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
