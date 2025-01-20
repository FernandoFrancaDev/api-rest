package app.celular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CelularService;

@SpringBootTest
public class CelularServiceTest {
	
	@Autowired
	CelularService celularService;
	
	@Test
	void cenario01() {
		List<Integer> lista = new ArrayList();
		lista.add(1);
		lista.add(3);
		lista.add(5);
		lista.add(5);
		
		int retorno = this.celularService.somar(lista);
		
		assertEquals(14, retorno);
		
	}

}
