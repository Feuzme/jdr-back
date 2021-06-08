package fr.jdr.spring.dto.sheet;

import java.util.List;

import fr.jdr.spring.models.ComposantEdit;
import fr.jdr.spring.models.GameType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateModelSheetDto {
	private String id;
	private String name;
	private Boolean isPublic;
	private GameType gameType;
	private List<ComposantEdit> composants;
}
