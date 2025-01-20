package app.computador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.ComputadorService;

@SpringBootTest
public class ComputadorServiceTest {
	
	@Autowired
	ComputadorService computadorService;
	
	@Test
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(2);
		lista.add(2);
		lista.add(2);
		
		int retorno = this.computadorService.somar(lista);
		
		assertEquals(8, retorno);
	}

}
