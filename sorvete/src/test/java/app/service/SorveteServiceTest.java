package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import app.entity.Sorvete;
import app.repository.SorveteRepository;

@SpringBootTest
public class SorveteServiceTest {
	
	@Autowired
	SorveteService sorveteService;
	
	@MockBean
	SorveteRepository sorveteRepository;
	
	@BeforeEach
	void setup() {
	List<Sorvete> lista = new ArrayList<>();
	lista.add(new Sorvete(2, "Sensação", "Morango", "Kibon", 2026, (null)));
	lista.add(new Sorvete(3, "Fruta", "Abacaxi", "Kibon", 2025, (null)));
	lista.add(new Sorvete(4, "Classico", "Chocolate", "Kibon", 2026, (null)));
	
	when(this.sorveteRepository.findAll()).thenReturn(lista);		
		
	}
	
	@Test
	void cenario01() {		
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		int retorno = this.sorveteService.somar(lista);
		assertEquals(10, retorno);
		
	}
	@Test
	void cenario02() {		
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		int retorno = this.sorveteService.somar(lista);
		assertEquals(9, retorno);
		
	}
	@Test
	void cenario03() {		
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertThrows(Exception.class, () -> {
			int retorno = this.sorveteService.somar(lista);			
		});
		
	}
	@Test
	void cenario04() {	
		
		List<Sorvete> lista = this.sorveteService.findAll();
		assertEquals(3, lista.size());
		
	}

}
