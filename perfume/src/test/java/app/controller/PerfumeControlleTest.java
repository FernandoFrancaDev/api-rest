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

import app.entity.Perfume;
import app.repository.PerfumeRepository;

@SpringBootTest
public class PerfumeControlleTest {
	
	@Autowired
	PerfumeController perfumeController;
	
	@MockBean
	PerfumeRepository perfumeRepository;
	
	@BeforeEach
	void setup() {
		List<Perfume> lista = new ArrayList<>();
		lista.add(new Perfume(1, "CK", 200));
		lista.add(new Perfume(2, "CK2", 300));
		lista.add(new Perfume(3, "CK3", 400));
		
		Perfume perfume = new Perfume(1, "CK", 150);
		
		when(perfumeRepository.findAll()).thenReturn(lista); // mock do find all
		when(perfumeRepository.findById(1L)).thenReturn(Optional.of(perfume)); // mock do findById
	}	
	
	@Test
	void cenario01() {
		
		
		ResponseEntity<List<Perfume>> retorno = this.perfumeController.findAll();
	//	assertEquals(HttpStatus.OK, retorno.getStatusCode());
		assertEquals(3, retorno.getBody().size());
		
	}
	@Test
	void cenario02() {				
		ResponseEntity<List<Perfume>> retorno = this.perfumeController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario03() {				
		ResponseEntity<Perfume> retorno = this.perfumeController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario04() {				
		ResponseEntity<Perfume> retorno = this.perfumeController.findById(1L);
		assertEquals(150, retorno.getBody().getPreco());	
	}
	@Test
	void cenario05() {				
		ResponseEntity<Perfume> retorno = this.perfumeController.findById(-1L);	
		assertEquals(HttpStatus.OK, retorno.getStatusCode());	
	}

}
