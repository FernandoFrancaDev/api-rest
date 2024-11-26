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

import app.entity.Comida;
import app.service.ComidaService;

@RestController
@RequestMapping("/api/comida")
public class ComidaController {
	
	@Autowired
	private ComidaService comidaService;
	
	@PostMapping("/save")
	public ResponseEntity<String>save(@RequestBody Comida comida){
		try {
			String mensagem = this.comidaService.save(comida);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String>update(@RequestBody Comida comida,@PathVariable long id){
		try {
			String mensagem = this.comidaService.update(comida, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>delete(@PathVariable long id){
		try {
			String mensagem = this.comidaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Comida>>findAll(){		
		try {
			List<Comida> lista = this.comidaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Comida>findById(@PathVariable Long id){		
		try {
			Comida comida = this.comidaService.findById(id);
			return new ResponseEntity<>(comida, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Comida>> findByNome(@RequestParam String nome){
		try {
			List<Comida> lista = this.comidaService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}	
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Comida>> findByMarca(@RequestParam long id){
		try {
			List<Comida> lista = this.comidaService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAcimaValidade")
	public ResponseEntity<List<Comida>> findAcimaValidade(int validade){
		try {
			List<Comida> lista = this.comidaService.findAcimaValidade(validade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
