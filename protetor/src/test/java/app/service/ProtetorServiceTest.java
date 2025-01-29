package app.service;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProtetorServiceTest {
	
	@Autowired
	ProtetorService protetorService;
	
	@Test
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.protetorService.somar(lista);
		assertEquals(12, retorno);
	}
	@Test
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(null);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.protetorService.somar(lista);
		assertEquals(10, retorno);
	}
	@Test
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(null);
		lista.add(4);
		lista.add(5);
		
		assertThrows(Exception.class, () -> {
			this.protetorService.somar(lista);
		});
	}

}
