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

import app.entity.Oculos;
import app.repository.OculosRepository;

@SpringBootTest
public class OculosControllerTest {
	
	@Autowired
	OculosController oculosController;
	
	@MockBean
	OculosRepository oculosRepository;
	
	@BeforeEach
	void setup() {
		List<Oculos> lista = new ArrayList();
		lista.add(new Oculos(1, "Oculos de Sol", "Sun", "Ryban", 2025, (null)));
		lista.add(new Oculos(2, "Oculos DayByDay", "DayByDay", "Ryban", 2025, (null)));
		lista.add(new Oculos(3, "Oculos de Sol", "Sunshine", "Ryban", 2025, (null)));
		
		Oculos oculos = new Oculos(3, "Oculos de Sol", "Sunshine", "Ryban", 2025, (null));
		
		when(oculosRepository.findAll()).thenReturn(lista);		
		when(oculosRepository.findById(1L)).thenReturn(Optional.of(oculos));
	}
	
	@Test
	void cenario01() {

		
		ResponseEntity<List<Oculos>> retorno = this.oculosController.findAll();
		assertEquals(3, retorno.getBody().size());
	}
	@Test
	void cenario02() {
		ResponseEntity<List<Oculos>>retorno = this.oculosController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario03() {
		ResponseEntity<Oculos> retorno = this.oculosController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario04() {
		ResponseEntity <Oculos> retorno = this.oculosController.findById(-1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario05() {
		ResponseEntity<Oculos> retorno = this.oculosController.findById(1L);
		assertEquals(2025, retorno.getBody().getAnoFabricacao());
	}

}
