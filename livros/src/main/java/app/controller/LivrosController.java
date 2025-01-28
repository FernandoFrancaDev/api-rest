package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livros;
import app.service.LivrosService;

@RestController
@RequestMapping("/api/livro")
public class LivrosController {
	
	@Autowired
	private LivrosService livrosService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> save(@RequestBody Livros livros){
		try {			
			String mensagem = this.livrosService.save(livros);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);		
		} catch (Exception e) {			
			return new ResponseEntity<>("Deu algo errado!", HttpStatus.BAD_REQUEST);
			
		}
	}	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Livros> findById(@PathVariable Long id){
		try {
			Livros livros = this.livrosService.findByID(id);
			return new ResponseEntity<>(livros, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}		
	}
	public ResponseEntity<List<Livros>> findAll(){
		try {
			List<Livros> lista = this.livrosService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
