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

import app.entity.Camera;
import app.service.CameraService;

@RestController
@RequestMapping("/api/camera")
public class CamaraController {
	
	@Autowired
	CameraService cameraService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Camera camera) {
		try {
			String mensagem = this.cameraService.save(camera);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Camera camera,@PathVariable long id) {
		try {
			String mensagem = this.cameraService.update(camera, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.cameraService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}		
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Camera>> findAll(){
		try {
			List<Camera> lista = this.cameraService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}		
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Camera> findById(@PathVariable long id) {
		try {
			Camera camera = this.cameraService.findById(id);
			return new ResponseEntity<>(camera, HttpStatus.BAD_GATEWAY);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
		}
	
	}

}
