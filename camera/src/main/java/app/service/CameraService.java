package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Camera;
import app.repository.CameraRepository;

@Service
public class CameraService {
	
	@Autowired
	CameraRepository cameraRepository;
	
	public String save(Camera camera) {
		this.cameraRepository.save(camera);
		return "Camera salva com sucesso";
	}
	public String update(Camera camera, long id) {
		camera.setId(id);
		this.cameraRepository.save(camera);
		return "Camera salva com sucesso";
	}
	public String delete(long id) {
		this.cameraRepository.deleteById(id);
		return "Camera salva com sucesso";
	}
	public List<Camera> findAll(){
		List<Camera> lista = this.cameraRepository.findAll();	
		return lista;
	}
	public Camera findById(long id) {
		Camera camera = this.cameraRepository.findById(id).get();
		return camera;
	}

}
