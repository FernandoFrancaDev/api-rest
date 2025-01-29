package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CameraServiceTest {
	
	@Autowired
	CameraService cameraService;
	
	@Test
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(5);
		
		int retorno = this.cameraService.somar(lista);
		assertEquals(8, retorno);
	}
	@Test
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(2);
		lista.add(5);
		
		int retorno = this.cameraService.somar(lista);
		assertEquals(7, retorno);
	}
	@Test
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(2);
		lista.add(5);
		
		assertThrows(Exception.class, () -> {
			this.cameraService.somar(lista);
		});
	}

}
