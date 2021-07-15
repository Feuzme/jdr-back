package fr.jdr.spring.dto.sheet;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateGameSheetCharacInfosDto {
	private String id;
	private Object characInfo;
}
