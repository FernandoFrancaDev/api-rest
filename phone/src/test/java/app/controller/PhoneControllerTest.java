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

import app.entity.Phone;
import app.repository.PhoneRepository;

@SpringBootTest
public class PhoneControllerTest {
	
	@Autowired
	PhoneController phoneController;
	
	@MockBean
	PhoneRepository phoneRepository;
	
	@BeforeEach
	void setup() {
		List<Phone> lista = new ArrayList();
		lista.add(new Phone(1, "Sony", 6000, (null)));
		lista.add(new Phone(2, "Motorola", 5000, (null)));
		lista.add(new Phone(3, "Ericson", 4000, (null)));
		
		Phone phone = new Phone(1, "Sony", 6000, (null));
		
		when(this.phoneRepository.findAll()).thenReturn(lista);
		when(this.phoneRepository.findById(1L)).thenReturn(Optional.of(phone));
		
	}
	
	@Test
	void cenario01() {		
		ResponseEntity<List<Phone>> retorno = this.phoneController.findAll();
		assertEquals(3, retorno.getBody().size());		
	}
	@Test
	void cenario02() {
		ResponseEntity<List<Phone>>retorno = this.phoneController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario03() {
		ResponseEntity<Phone> retorno = this.phoneController.findById(1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
		
	}
	@Test
	void cenario04() {
		ResponseEntity<Phone> retorno = this.phoneController.findById(-1L);
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}
	@Test
	void cenario() {
		ResponseEntity<Phone> retorno = this.phoneController.findById(1L);
		assertEquals(6000, retorno.getBody().getValor());
	}

}
