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

import app.entity.Bone;
import app.service.BoneService;

@RestController
@RequestMapping("/api/bone")
public class BoneController {
	
	@Autowired
	private BoneService boneService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Bone bone) {
		try {
			String mensagem = this.boneService.save(bone);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
		}
	@PutMapping("/update/{id}")
		public ResponseEntity<String> update(@RequestBody Bone bone,@PathVariable long id) {
			try {
				String mensagem = this.boneService.update(bone, id);
				return new ResponseEntity<>(mensagem, HttpStatus.OK);				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}			
		}
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable long id) {
			try {
				String mensagem = this.boneService.delete(id);
				return new ResponseEntity<>(mensagem, HttpStatus.OK);				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}			
		}
	@GetMapping("/findAll")
		public ResponseEntity<List<Bone>>findAll(){
		try {
			List<Bone> lista = this.boneService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}		
		}
	@GetMapping("/findById/{id}")
		public ResponseEntity<Bone> findById(@PathVariable long id) {
		try {
			Bone bone = this.boneService.findById(id);
			return new ResponseEntity<>(bone, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
			
		}

}
