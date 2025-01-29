package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImpressoraServiceTest {
	
	@Autowired
	ImpressoraService impressoraService;
	
	@Test
	void cenario01() {
		List<Integer>lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.impressoraService.somar(lista);
		assertEquals(12, retorno);
	}
	@Test // neste teste é preciso ajustar o código com if(lista.get(i) != null)
	void cenario02() {
		List<Integer>lista = new ArrayList<>();
		lista.add(1);
		lista.add(null);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.impressoraService.somar(lista);
		assertEquals(10, retorno);
	}
	@Test // retornará um erro esperado
	void cenario03() {
		List<Integer>lista = new ArrayList<>();
		lista.add(1);
		lista.add(null);
		lista.add(4);
		lista.add(5);
		
		assertThrows(Exception.class, () -> {
			this.impressoraService.somar(lista);
		});
	}

}
