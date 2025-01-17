package app.aritimetica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.Aritimetica03Service;

@SpringBootTest
public class Aritimetica03ServiceTest {
	
	@Autowired
	Aritimetica03Service aritimetica03Service;
	
	@Test
	void cenario01() {
	List<Integer> lista = new ArrayList<>();	
	lista.add(1);
	lista.add(4);
	lista.add(5);
	
	int retorno =  this.aritimetica03Service.somar(lista);
	
	assertEquals(10, retorno);
	
	}
	@Test
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.aritimetica03Service.buscarMaiorNumero(lista);
		assertEquals(5, retorno);
		
	}
	
	

}
