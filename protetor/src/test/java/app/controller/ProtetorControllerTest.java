package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Protetor;
import app.repository.ProtetorRepository;

@SpringBootTest
public class ProtetorControllerTest {
	
	@Autowired
	ProtetorController protetorController;
	
	@Mock
	ProtetorRepository protetorRepository;
	
	@BeforeEach
	void setup() {
		List<Protetor> lista = new ArrayList<>();
		lista.add(new Protetor(1, "Sundow", 2026, (null)));
		lista.add(new Protetor(2, "Flex", 2025, (null)));
		lista.add(new Protetor(3, "BeiraMar", 2024, (null)));
		
		Protetor protetor = new Protetor(4, "Baixada", 2025, (null));
		
		when(this.protetorRepository.findAll()).thenReturn(lista);
		when(this.protetorRepository.findById(-1L)).thenReturn(Optional.of(protetor));
	}
	
	@Test
	void cenario01() {		
		ResponseEntity<List<Protetor>> retorno = this.protetorController.findAll();
		assertEquals(3, retorno.getBody().size());		
	}
	@Test
	void cenario02() {
		ResponseEntity<List<Protetor>> retorno = this.protetorController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario03() {
		ResponseEntity<Protetor> retorno = this.protetorController.findById(2L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario04() {
		ResponseEntity<Protetor> retorno = this.protetorController.findById(2L);
		Protetor protetor = retorno.getBody();
		assertEquals(2030, protetor.getValidade());		
	}
	@Test
	void cenario05() {
		ResponseEntity<Protetor >retorno = this.protetorController.findById(-2L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}

}
