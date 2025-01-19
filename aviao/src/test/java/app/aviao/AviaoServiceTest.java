package app.aviao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.AviaoService;

@SpringBootTest
public class AviaoServiceTest {
	
	@Autowired
	AviaoService aviaoService;
	
	@Test
	void cenario01(){
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		
		int retorno = this.aviaoService.somar(lista);
		
		assertEquals(14, retorno);
		
		
	}

}
