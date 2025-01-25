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

import app.entity.Roupas;
import app.repository.RoupasRepository;

@SpringBootTest
public class RoupasControllerTest {
	
	@Autowired
	RoupasController roupasController;
	
	@MockBean
	RoupasRepository roupasRepository;
	
	@BeforeEach
	void setup() {
		List<Roupas> lista = new ArrayList();
		lista.add(new Roupas(1, "Blusinha", "Blusinha Regata", "Pakalolo", 100, (null)));
		lista.add(new Roupas(2, "calça", "Pantalona", "Vilejack", 150, (null)));
		lista.add(new Roupas(3, "Short", "Linho Fino", "Barrreds", 70, (null)));
		
		Roupas roupas = new Roupas(3, "Short", "Linho Fino", "Barrreds", 100, (null));
		
		when(roupasRepository.findAll()).thenReturn(lista);
		when(roupasRepository.findById(1L)).thenReturn(Optional.of(roupas));
		
	}
	
	@Test
	void cenario01() {				
		ResponseEntity<List<Roupas>> retorno = this.roupasController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario02() {				
		ResponseEntity<List<Roupas>> retorno = this.roupasController.findAll();
		assertEquals(3, retorno.getBody().size());		
	}
	@Test
	void  cenario03() {
		ResponseEntity<Roupas> retorno = this.roupasController.findById(1L);//Para funcionar o mock deve receber o 1L no findById(1L)
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario04() {
		ResponseEntity<Roupas> retorno = this.roupasController.findById(-1L);//Para funcionar o mock deve receber o 1L no findById(1L)
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario05() {
		ResponseEntity<Roupas> retorno = this.roupasController.findById(1L);
		assertEquals(100, retorno.getBody().getPreco());
	}

}
