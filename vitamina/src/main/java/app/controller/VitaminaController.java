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

import app.entity.Vitamina;
import app.service.VitaminaService;

@RestController
@RequestMapping("/api/vitamina")
public class VitaminaController {
	
	@Autowired
	private VitaminaService vitaminaService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> save(@RequestBody Vitamina vitamina) {
		try {
			String mensagem = this.vitaminaService.save(vitamina);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Vitamina vitamina,@PathVariable long id) {
		try {
			String mensagem = this.vitaminaService.update(vitamina, id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.vitaminaService.delete(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Vitamina>>findAll(){
		try {
			List<Vitamina> lista = this.vitaminaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Vitamina> findById(@PathVariable long id) {
		try {
			Vitamina vitamina = this.vitaminaService.findById(id);
			return new ResponseEntity<>(vitamina, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
