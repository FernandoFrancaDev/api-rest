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

import app.entity.Entrada;
import app.entity.Impressora;
import app.entity.Resultado;
import app.service.ImpressoraService;

@RestController
@RequestMapping("/api/impressora")
public class ImpressoraController {
	
	@Autowired
	private ImpressoraService impressoraService;
	
	@GetMapping("/calcular")
	public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada){		
		try {
			Resultado resultado = this.impressoraService.calcular(entrada);
			return new ResponseEntity<Resultado>(resultado, HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);			
		}
	}
	@PostMapping("/salvar")
	public ResponseEntity<String> save(@RequestBody Impressora impressora){		
		try {			
			String mensagem = this.impressoraService.save(impressora);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Impressora> findById(@PathVariable Long id){		
		try {			
			Impressora impressora = this.impressoraService.findById(id);
			return new ResponseEntity<>(impressora, HttpStatus.OK);					
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);			
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Impressora>> findAll(){
		try {
			List<Impressora>lista = this.impressoraService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
	
	

}
