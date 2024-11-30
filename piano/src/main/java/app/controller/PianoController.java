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

import app.entity.Piano;
import app.service.PianoService;

@RestController
@RequestMapping("/api/piano")
public class PianoController {
	
	@Autowired
	private PianoService pianoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save (@RequestBody Piano piano) {
		try {
			String mensagem = this.pianoService.save(piano);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Piano piano,@PathVariable long id) {
		try {
			String mensagem = this.pianoService.update(piano, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.pianoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Piano>> findAll(){
		try {
			List<Piano> lista = this.pianoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Piano> findById(@PathVariable long id) {
		try {
			Piano piano = this.pianoService.findById(id);
			return new ResponseEntity<>(piano, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Piano>> findByNome(String nome){
		try {
			List<Piano> lista = this.pianoService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Piano>> findByMarca(@RequestParam long id){
		try {
			List<Piano> lista = this.pianoService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findAcimaAno")
	public ResponseEntity<List<Piano>> findAcimaAno(@RequestParam String anoFabricacao){
		try {
			List<Piano> lista = this.pianoService.findAcimaAno(anoFabricacao);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
