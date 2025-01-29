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

import app.entity.Impressora;
import app.repository.ImpressoraRepository;

@SpringBootTest
public class ImpressoraControllerTest {
	
	@Autowired
	ImpressoraController impressoraController;
	
	@MockBean
	ImpressoraRepository impressoraRepository;
	
	@BeforeEach
	void setup() {
		List<Impressora> lista = new ArrayList();
		lista.add(new Impressora(1, "HP LaserJet", "HP2008", "HP", 2008));
		lista.add(new Impressora(2, "Epson", "EP319", "Epson", 2015));
		lista.add(new Impressora(3, "Cannon", "Ca2000", "Cannon", 2010));
		lista.add(new Impressora(4, "Samsung", "SGB3035", "Samsung", 2014));
		
		Impressora impressora = new Impressora(4, "Samsung", "SGB3035", "HP", 2014);
		
		when(this.impressoraRepository.findAll()).thenReturn(lista);
		when(this.impressoraRepository.findById(-1L)).thenReturn(Optional.of(impressora));
	}
	
	@Test
	void cenario01() {		
		ResponseEntity<List<Impressora>>retorno = this.impressoraController.findAll();
		assertEquals(4, retorno.getBody().size());
		
	}
	@Test
	void cenario02() {
		ResponseEntity<List<Impressora>> retorno = this.impressoraController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario03() {
		ResponseEntity<Impressora>retorno = this.impressoraController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario04() {
		ResponseEntity<Impressora>retorno = this.impressoraController.findById(-1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario05() {
		ResponseEntity<Impressora>retorno = this.impressoraController.findById(1L);
		assertEquals("HP" , retorno.getBody().getMarca());
	}

}
