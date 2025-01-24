package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Sorvete;
import app.repository.SorveteRepository;

@SpringBootTest
public class SorveteControllerTest {
	
	@Autowired
	SorveteController sorveteController;
	
	@MockBean
	SorveteRepository sorveteRepository;
	
	@BeforeEach
	void setup () {
		List<Sorvete> lista = new ArrayList<>();
		lista.add(new Sorvete(1, "Verao", "Maracuja", "Kibon", 2025, (null)));
		lista.add(new Sorvete(2, "Sensação", "Morango", "Kibon", 2026, (null)));
		lista.add(new Sorvete(3, "Fruta", "Abacaxi", "Kibon", 2025, (null)));
		lista.add(new Sorvete(4, "Classico", "Chocolate", "Kibon", 2026, (null)));
		
		Sorvete sorvete = new Sorvete(4, "Classico", "Chocolate", "Kibon", 2026, (null));
		
		when(this.sorveteRepository.findAll()).thenReturn(lista);
		when(this.sorveteRepository.findById(1L)).thenReturn(Optional.of(sorvete));
		
	}
	
	@Test
	void cenario01() {		
		ResponseEntity<List<Sorvete>> retorno = this.sorveteController.findAll();
		assertEquals(4, retorno.getBody().size());		
	}
	@Test
	void cenario02() {
		ResponseEntity<List<Sorvete>> retorno = this.sorveteController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario03() {
		ResponseEntity<Sorvete> retorno = this.sorveteController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario04() {
		ResponseEntity<Sorvete> retorno = this.sorveteController.findById(1L);
		assertEquals(2026, retorno.getBody().getValidade());
	}
	@Test
	void cenario05() {
		ResponseEntity<Sorvete> retorno = this.sorveteController.findById(-1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
}
