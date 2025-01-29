package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Phone;
import app.entity.Saida;
import app.service.PhoneService;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Phone phone) {
		try {
			String mensagem = this.phoneService.save(phone);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Phone phone,@PathVariable long id) {
		try {
			String mensagem = this.phoneService.update(phone, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}		
	}
	@DeleteMapping("/delete/{id}")	
	public ResponseEntity<String> delete (@PathVariable long id) {
		try {
			String mensagem = this.phoneService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Phone>> findAll(){
		try {
			List<Phone>lista = this.phoneService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Phone> findById(@PathVariable long id) {
		try {
			Phone phone = this.phoneService.findById(id);
			return new ResponseEntity<>(phone, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	}
	@GetMapping("/somar")
	public ResponseEntity<Saida> calcular(Phone phone) {
		try {
			Saida saida = this.phoneService.calcular(phone);
			return new ResponseEntity<>(saida, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}

}
