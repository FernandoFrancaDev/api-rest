package app.controller;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Livros;
import app.repository.LivrosRepository;

@SpringBootTest
public class LivrosControllerTest {
	
	@Autowired
	LivrosController livrosController;
	
	@MockBean
	LivrosRepository livrosRepository;
	
	@Test
	void cenario01() {
		List<Livros>lista = new ArrayList();
		lista.add(new Livros(1, "Drogas matam", "Luiz Arthur", "Vida", 2002, (null)));
		lista.add(new Livros(2, "Ouvir Dizer", "Elo", "Elo", 1979, (null)));
		lista.add(new Livros(2, "Louvores", "VPC", "VPC", 2015, (null)));
		
		Livros livros = new Livros(1, "Louvores", "VPC", "VPC", 2015, (null));
		
		
		when(this.livrosRepository.findAll()).thenReturn(lista);
		when(this.livrosRepository.findById(1L)).thenReturn(Optional.of(livros));
		
		ResponseEntity<List<Livros>> retorno = this.livrosController.findAll();
		assertEquals(3, retorno.getBody().size());
	}
	@Test
	void cenario02() {
		 ResponseEntity<List<Livros>>retorno = this.livrosController.findAll();
		 assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario03() {
		ResponseEntity<Livros> retorno = this.livrosController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario04() {
		ResponseEntity<Livros>retorno = this.livrosController.findById(-1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario05() {
		ResponseEntity<Livros> retorno = this.livrosController.findById(1L);
		assertEquals(2015, retorno.getBody().getLancamento());
	}

}
