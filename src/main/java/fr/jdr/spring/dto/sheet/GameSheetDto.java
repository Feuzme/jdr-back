package fr.jdr.spring.dto.sheet;

import fr.jdr.spring.models.ModelSheet;
import fr.jdr.spring.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameSheetDto {
	private String id;
	private ModelSheet model;
	private User user;
	private Object characInfos;
}
