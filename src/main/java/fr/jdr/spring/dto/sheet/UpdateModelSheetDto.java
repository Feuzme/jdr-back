package fr.jdr.spring.dto.sheet;

import java.util.List;

import fr.jdr.spring.models.BasePluginEdit;
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
	private List<BasePluginEdit> composants;
}
