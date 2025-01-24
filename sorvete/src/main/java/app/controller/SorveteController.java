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

import app.entity.Saida;
import app.entity.Sorvete;
import app.service.SorveteService;

@RestController
@RequestMapping("/api/sorvete")
public class SorveteController {
	
	@Autowired
	SorveteService sorveteService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String>save(@RequestBody Sorvete sorvete){
		
		try {
			String mensagem = this.sorveteService.save(sorvete);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Sorvete>findById(@PathVariable Long id){
		
		try {			
			Sorvete sorvete = this.sorveteService.findById(id);
			return new ResponseEntity<>(sorvete,HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Sorvete>> findAll(){
		try {
			List<Sorvete> lista = this.sorveteService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}		
	}
	@GetMapping("/somar")
	public ResponseEntity<Saida> calcular(@RequestBody Sorvete sorvete) {
		try {
			Saida saida = this.sorveteService.calcular(sorvete);
			return new ResponseEntity<>(saida, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
	

}
