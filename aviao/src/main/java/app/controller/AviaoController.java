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

import app.entity.Aviao;
import app.entity.Entrada;
import app.entity.Resultado;
import app.service.AviaoService;

@RestController
@RequestMapping("/api/aviao")
public class AviaoController {
	
	@Autowired
	private AviaoService aviaoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Aviao aviao) {
		try {
			String mensagem = this.aviaoService.save(aviao);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	@PutMapping("/update/{id}")
	public  ResponseEntity<String> update(@RequestBody Aviao aviao,@PathVariable long id) {
		try {
			String mensagem = this.aviaoService.update(aviao, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.aviaoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/findAll")
	public  ResponseEntity<List<Aviao>> FindAll() {
		try {
			List<Aviao> lista = this.aviaoService.FindAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findById/{id}")
	public  ResponseEntity<Aviao> FindById(@PathVariable long id) {
		try {
			Aviao aviao = this.aviaoService.FindById(id);
			return new ResponseEntity<>(aviao, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/findByNome")
	public ResponseEntity<List<Aviao>> findByNome(@RequestParam String nome){
		try {
			List<Aviao> lista = this.aviaoService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
	}
	@GetMapping("/findByMarca")
	public ResponseEntity<List<Aviao>> findByMarca(@RequestParam long id){
		try {
			List<Aviao> lista = this.aviaoService.findByMarca(id);
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findAcimaAno")
	public ResponseEntity<List<Aviao>> findAcimaAno (@RequestParam int ano){
		try {
			List<Aviao> lista = this.aviaoService.findAcimaAno(ano);
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/somar")
	public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada) {
		try {
			Resultado resultado = this.aviaoService.calcular(entrada);
			return new ResponseEntity<>(resultado, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}			
	}

}
