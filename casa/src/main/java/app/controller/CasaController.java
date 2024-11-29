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

import app.entity.Casa;
import app.service.CasaService;

@RestController
@RequestMapping("/api/casa")
public class CasaController {
	
	@Autowired
	private CasaService casaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Casa casa) {
		try {
			String mensagem = this.casaService.save(casa);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Casa casa,@PathVariable long id) {
		try {
			String mensagem = this.casaService.update(casa, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.casaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Casa>> findAll(){
		try {
			List<Casa> lista = this.casaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Casa> findById(@PathVariable long id) {
		try {
			Casa casa = this.casaService.findById(id);
			return new ResponseEntity<>(casa, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Casa>> findByNome(@RequestParam String nome){
		try {
			List<Casa> lista = this.casaService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Casa>> findByMarca(@RequestParam long id){
		try {
			List<Casa> lista = this.casaService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAcimaAnoFabricacao")
	public ResponseEntity<List<Casa>> findAcimaAnoFabricacao (@RequestParam int anoFabricacao){
		try {
			List<Casa> lista = this.casaService.findAcimaAnoFabricacao(anoFabricacao);			
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
