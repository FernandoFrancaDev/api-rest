package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Entrada;
import app.entity.Resultado;
import app.service.Aritimetica03Service;

@RestController
@RequestMapping("/api")
public class Aritimetica03Controller {
	
	@Autowired
	private Aritimetica03Service aritimetica03Service;
	
	@GetMapping("/calcular")
	public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada) {
		try {
			Resultado resultado = this.aritimetica03Service.calcular(entrada);
			return new ResponseEntity<>(resultado, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	}

}
