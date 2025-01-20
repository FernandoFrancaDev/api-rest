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

import app.entity.Celular;
import app.entity.Entrada;
import app.entity.Resultado;
import app.service.CelularService;

@RestController
@RequestMapping("/api/celular")
public class CelularController {
	
	@Autowired
	private CelularService celularService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String>save(@RequestBody Celular celular){		
		try {
			String mensagem = this.celularService.save(celular);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Deu algo errado no salvar", HttpStatus.BAD_REQUEST);				
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String>update(@RequestBody Celular celular,@PathVariable long id){		
		try {
			String mensagem = this.celularService.update(celular, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Deu algo errado no salvar", HttpStatus.BAD_REQUEST);				
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>delete(@PathVariable long id){		
		try {
			String mensagem = this.celularService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Deu algo errado no salvar", HttpStatus.BAD_REQUEST);				
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity <List<Celular>>findAll(){		
		try {
			List<Celular> lista = this.celularService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);				
		}
	}	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Celular> findById(@PathVariable Long id){		
		try {			
			Celular celular = this.celularService.findById(id);
			return new ResponseEntity<>(celular, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);		
		}		
	}
	@GetMapping("/calcular")
	public ResponseEntity<Resultado>scalcular(@RequestBody Entrada entrada){
		
		try {
			Resultado resultado = this.celularService.calcular(entrada);
			return new ResponseEntity<Resultado>(resultado, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);			
		}
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Celular>> findByNome(@RequestParam String nome){
		try {
			List<Celular> lista = this.celularService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);			
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Celular>> findByMarca(@RequestParam long id){
		try {
			List<Celular> lista = this.celularService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAcimaAno")
	public ResponseEntity<List<Celular>> findAcimaAno(@RequestParam int ano){
		try {
			List<Celular> lista = this.celularService.findAcimaAno(ano);
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
