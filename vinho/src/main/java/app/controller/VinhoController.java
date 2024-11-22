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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Vinho;
import app.service.VinhoService;

@RestController
@RequestMapping("/api/vinho")
public class VinhoController {
	
	@Autowired
	private VinhoService vinhoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Vinho vinho) {
		try {
			String mensagem = this.vinhoService.save(vinho);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Vinho vinho,@PathVariable long id) {
		try {
			String mensagem = this.vinhoService.update(vinho, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.vinhoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Vinho>> findAll(){
		try {
			List<Vinho> lista = this.vinhoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Vinho> findById(@PathVariable long id) {
		try {
			Vinho vinho = this.vinhoService.findById(id);
			return new ResponseEntity<>(vinho, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Vinho>> findByNome(@RequestParam String nome) {
		try {
			List<Vinho> lista = this.vinhoService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Vinho>> findByMarca(@RequestParam long id) {
		try {
			List<Vinho> lista = this.vinhoService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}

}
