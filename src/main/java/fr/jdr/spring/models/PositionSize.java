package fr.jdr.spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionSize {
	private int x;
	private int y;
	private int height;
	private int width;
}
