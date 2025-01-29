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

import app.entity.Oculos;
import app.entity.Saida;
import app.service.OculosService;

@RestController
@RequestMapping("/api/oculos")
public class OculosController {
	
	@Autowired
	private OculosService oculosService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String>save(@RequestBody Oculos oculos){
		
		try {
			String mensagem = this.oculosService.save(oculos);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Oculos>findById(@PathVariable Long id){
		
		try {			
			Oculos oculos = this.oculosService.findById(id);
			return new ResponseEntity<>(oculos, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Oculos>> findAll(){
		try {
			List<Oculos>lista = this.oculosService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
	@GetMapping("/calcular")
	public ResponseEntity<Saida> calcular(@RequestBody Oculos oculos) {
		try {
			Saida saida = this.oculosService.calcular(oculos);
			return new ResponseEntity<>(saida, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}

}
