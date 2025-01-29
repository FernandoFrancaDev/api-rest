package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OculosServiceTest {
	
	@Autowired
	OculosService oculosService;
	
	@BeforeEach
	void setup() {
		List<Integer> lista = new ArrayList();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
	}
	
	@Test
	void cenario01() {	
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		int retorno = this.oculosService.somar(lista);
		assertEquals(10, retorno);
	}
	@Test // calcular mesmo com numero nulo acrescentar no metodo ante de somar --	if(lista.get(i) != null)
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		int retorno = this.oculosService.somar(lista);
		assertEquals(9, retorno);
	}
	@Test // neste caso é esperado o erro pois existe o null
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertThrows(Exception.class, () ->{
			this.oculosService.somar(lista);
		});
	}

}
