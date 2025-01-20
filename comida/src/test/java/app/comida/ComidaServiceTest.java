package app.comida;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.ComidaService;

@SpringBootTest
public class ComidaServiceTest {
	
	@Autowired
	ComidaService comidaService;
	
	@Test
	void cenario01() {
		List<Integer> lista = new ArrayList();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		int retorno = this.comidaService.somar(lista);
		
		assertEquals(10, retorno);
	}

}
