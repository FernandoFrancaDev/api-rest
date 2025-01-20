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

import app.entity.Computador;
import app.entity.Entrada;
import app.entity.Saida;
import app.service.ComputadorService;

@RestController
@RequestMapping("/api/computador")
public class ComputadorController {
	
	@Autowired
	ComputadorService computadorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Computador computador){
		
		try {			
			String mensagem = this.computadorService.save(computador);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado", HttpStatus.BAD_REQUEST);			
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Computador computador,@PathVariable long id){		
		try {			
			String mensagem = this.computadorService.update(computador, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);			
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){		
		try {			
			String mensagem = this.computadorService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);			
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Computador>> findAll(){
		try {
			List<Computador> lista = this.computadorService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Computador>findById(@PathVariable Long id){		
		try {			
			Computador computador = this.computadorService.findById(id);
			return new ResponseEntity<>(computador, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Computador>> findByNome (@RequestParam String nome){
		try {
			List<Computador> lista = this.computadorService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByMarca")
	public ResponseEntity <List<Computador>> findByMarca(@RequestParam long id){
		try {
			List<Computador> lista = this.computadorService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAcimaValor")
	public ResponseEntity <List<Computador>> findAcimaValor(@RequestParam double valor){
		try {
		List<Computador> lista = this.computadorService.findAcimaValor(valor);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/somar")
	public ResponseEntity<Saida> calcular(@RequestBody Entrada entrada) {
		try {
			Saida saida = this.computadorService.calcular(entrada);
			return new ResponseEntity<>(saida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
