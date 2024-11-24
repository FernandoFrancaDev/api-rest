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

import app.entity.Motos;
import app.service.MotosService;

@RestController
@RequestMapping("/api/moto")
public class MotosController {
	
	@Autowired
	private MotosService motosService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Motos motos){		
		try {			
			String mensagem = this.motosService.save(motos);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado", HttpStatus.BAD_REQUEST);			
		}
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(Motos motos, long id) {
		try {
			String mensagem = this.motosService.update(motos, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado", HttpStatus.BAD_REQUEST);	
		}
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(long id) {		
		try {
			String mensagem = this.motosService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado", HttpStatus.BAD_REQUEST);	
		}	
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Motos>> findAll() {		
		try {
			List<Motos> lista = this.motosService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("findById/{id}")
	public ResponseEntity<Motos>findById(@PathVariable Long id){
		
		try {
			Motos motos= this.motosService.findById(id);
			return new ResponseEntity<>(motos, HttpStatus.OK);
						
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Motos>> findByNome(@RequestParam String nome){
		try {
			List<Motos> lista = this.motosService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Motos>> findByNome(@RequestParam long id){
		try {
			List<Motos> lista = this.motosService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAcimaAno")
	public ResponseEntity<List<Motos>> findAcimaAno(@RequestParam int ano){
		try {
			List<Motos> lista = this.motosService.findAcimaAno(ano);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
