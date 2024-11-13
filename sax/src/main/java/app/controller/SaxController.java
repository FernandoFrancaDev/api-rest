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

import app.entity.Sax;
import app.service.SaxService;

@RestController
@RequestMapping("/api/sax")
public class SaxController {
	
	@Autowired
	private SaxService saxService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Sax sax) {
		try {
			String mensagem  = this.saxService.save(sax);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
		
	@PutMapping("/updateq{id}")
	public ResponseEntity<String> updade (@RequestBody Sax sax,@PathVariable long id) {
		try {
			String mensagem = this.saxService.updade(sax, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.saxService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Sax>> findAll(){
		try {
			List<Sax> lista = this.saxService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Sax> findById(@PathVariable long id) {
		try {
			Sax sax = this.saxService.findById(id);
			return new ResponseEntity<>(sax, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	
	}

}
