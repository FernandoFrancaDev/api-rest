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

import app.entity.Roupas;
import app.service.RoupasService;

@RestController
@RequestMapping("/api/roupas")
public class RoupasController {
	
	@Autowired
	private RoupasService roupasService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String>save(@RequestBody Roupas roupas){
		try {
			String mensagem = this.roupasService.save(roupas);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);			
			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.OK);
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Roupas>findById(@PathVariable Long id){
		try {
			Roupas roupas = this.roupasService.findById(id);
			return new ResponseEntity<>(roupas, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Roupas>> findAll(){
		try {
			List<Roupas> lista = this.roupasService.findAll();
			 return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
	

}
