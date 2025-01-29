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

import app.entity.Protetor;
import app.entity.Saida;
import app.service.ProtetorService;

@RestController
@RequestMapping("/api/protetor")
public class ProtetorController {
	
	@Autowired
	private ProtetorService protetorservice;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> save(@RequestBody Protetor protetor) {
		try {
			String mensagem = this.protetorservice.save(protetor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String> update(@RequestBody Protetor protetor,@PathVariable long id) {
		try {
			String mensagem = this.protetorservice.update(protetor, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.protetorservice.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Protetor>> findAll() {
		try {
			List<Protetor> lista = this.protetorservice.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Protetor> findById(@PathVariable long id) {
		try {
			Protetor protetor = this.protetorservice.findById(id);
			return new ResponseEntity<>(protetor, HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	public ResponseEntity<Saida> calcular(@RequestBody Protetor protetor) {
		try {
			Saida saida = this.protetorservice.calcular(protetor);
			return new ResponseEntity<>(saida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}


}
