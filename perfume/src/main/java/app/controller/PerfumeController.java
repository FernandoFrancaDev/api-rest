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

import app.entity.Perfume;
import app.service.PerfumeService;

@RestController
@RequestMapping("/api/perfume")
public class PerfumeController {
	
	@Autowired
	PerfumeService perfumeService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Perfume perfume) {
		try {
			String mensagem = this.perfumeService.save(perfume);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{id}")
	public  ResponseEntity<String> update(@RequestBody Perfume perfume,@PathVariable long id) {
		try {
			String mensagem = this.perfumeService.update(perfume, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.perfumeService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public  ResponseEntity<List<Perfume>> findAll(){
		try {
			List<Perfume> lista = this.perfumeService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/findById/{id}")
	public  ResponseEntity<Perfume> findById(@PathVariable long id) {
		try {
			Perfume perfume = this.perfumeService.findById(id);
			return new ResponseEntity<>(perfume, HttpStatus.OK);
			} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}

}
