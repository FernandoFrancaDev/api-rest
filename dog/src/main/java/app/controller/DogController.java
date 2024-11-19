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

import app.entity.Dog;
import app.service.DogService;

@RestController
@RequestMapping("/api/dog")
public class DogController {
	
	@Autowired
	private DogService dogservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Dog dog) {
		try {
			String mensagem = this.dogservice.save(dog);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@PutMapping("/update/{Id}")
	public  ResponseEntity<String> update (@RequestBody Dog dog,@PathVariable long id) {
		try {
			String mensagem = this.dogservice.update(dog, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem  = this.dogservice.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findAll")
	public  ResponseEntity<List<Dog>> findAll(){
		try {
			List<Dog> lista = this.dogservice.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("findById/{id}")
	public  ResponseEntity<Dog> findById(@PathVariable long id) {
		try {
			Dog dog = this.dogservice.findById(id);
			return new ResponseEntity<>(dog, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}

}
