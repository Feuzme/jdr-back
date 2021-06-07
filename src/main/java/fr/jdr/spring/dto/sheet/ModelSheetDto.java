package fr.jdr.spring.dto.sheet;

import fr.jdr.spring.models.GameType;
import fr.jdr.spring.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModelSheetDto {
	private String id;
	private String name;
	private User user;
	private Boolean isPublic;
	private GameType gameType;
}
