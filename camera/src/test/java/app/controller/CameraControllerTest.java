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

import app.entity.Camera;
import app.repository.CameraRepository;

@SpringBootTest
public class CameraControllerTest {
	
	@Autowired
	CameraController cameraController;
	
	@MockBean
	CameraRepository cameraRepository;
	
	@BeforeEach
	void setup() {
		List<Camera>lista = new ArrayList<>();
		lista.add(new Camera(1, "Yashica", 1998, 1000.00));
		lista.add(new Camera(2, "Kodak", 2000, 2000.00));
		lista.add(new Camera(3, "Fuji", 2001, 1500.00));
		
		Camera camera = new Camera(1, "Canon", 2002, 1200.00);
		
		when(cameraRepository.findAll()).thenReturn(lista);	
		when(cameraRepository.findById(1L)).thenReturn(Optional.of(camera));
	}
	
	@Test
	void cenario01() {
		
		ResponseEntity<List<Camera>>retorno = this.cameraController.findAll();
		assertEquals(3, retorno.getBody().size());		
	}
	@Test
	void cenario02() {
		
		ResponseEntity<List<Camera>>retorno = this.cameraController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());		
	}
	@Test
	void cenario03() {
		
		ResponseEntity<Camera> retorno = this.cameraController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario04() {
		
		ResponseEntity<Camera>retorno = this.cameraController.findById(-1L);
		Camera camera = retorno.getBody();
		assertEquals(1200.00, camera.getPreco());		
	}

	

}
