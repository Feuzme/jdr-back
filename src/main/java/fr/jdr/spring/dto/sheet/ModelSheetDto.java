package fr.jdr.spring.dto.sheet;

import java.util.List;

import fr.jdr.spring.models.ComposantEdit;
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
	private List<ComposantEdit> composants; //recupérer les dto de Najib/!\
}
