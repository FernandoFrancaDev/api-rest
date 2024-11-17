//Deus tú és soberano neste projeto! Jesus pela tua graça estou aqui!
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

import app.entity.Sapato;
import app.service.SapatoService;

@RestController
@RequestMapping("/api/sapato")
public class SapatoController {
	
	@Autowired
	private SapatoService sapatoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Sapato sapato) {
		try {
			String mensagem = this.sapatoService.save(sapato);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String>update(@RequestBody Sapato sapato,@PathVariable long id) {
		try {
			String mensagem = this.sapatoService.update(sapato, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.sapatoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Sapato>> findAll(){
		try {
			List<Sapato> lista = this.sapatoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Sapato> findById(@PathVariable long id) {
		try {
			Sapato sapato = this.sapatoService.findById(id);
			return new ResponseEntity<>(sapato, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}


}
