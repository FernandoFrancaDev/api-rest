package app.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {
	
	private int soma;
	private Double media;
	private int maior;
	private int menor;
	private int total;

}
