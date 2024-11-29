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

import app.entity.Teclado;
import app.service.TecladoService;

@RestController
@RequestMapping("/api/teclado")
public class TecladoController {
	
	@Autowired
	private TecladoService tecladoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> save(@RequestBody Teclado teclado) {
		try {
			String mensagem = this.tecladoService.save(teclado);
			return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Teclado teclado,@PathVariable long id) {
		try {
			String mensagem = this.tecladoService.update(teclado, id);
			return new ResponseEntity<>(mensagem, HttpStatus.CREATED);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.tecladoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}	
		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Teclado>> findAll() {
		try {
			List<Teclado> lista = this.tecladoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}	
		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Teclado> findById(@PathVariable long id) {
		try {
			Teclado teclado = this.tecladoService.findByIf(id);
			return new ResponseEntity<>(teclado, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Teclado>> findByNome(@RequestParam String nome){
		try {
		List<Teclado> lista = this.tecladoService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Teclado>> findByMarca(@RequestParam long id){
		try {
			List<Teclado> lista = this.tecladoService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAcimaAno")
	public ResponseEntity<List<Teclado>> findAcimaAno (@RequestParam int ano){
		try {
		List<Teclado> lista = this.tecladoService.findAcimaAno(ano);
			return new ResponseEntity<>(lista, HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	

}
