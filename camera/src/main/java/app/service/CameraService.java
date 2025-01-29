package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Camera;
import app.entity.Saida;
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
	public Saida calcular(Camera camera) {
		Saida saida = new Saida();
		saida.setSoma(this.somar(camera.getLista()));
		return null;
	}
	public int somar(List<Integer> lista) {
		int soma = 0;
		for(int i = 0; i < lista.size(); i++)
			if(lista.get(i) != null)
			soma += lista.get(i);
		return soma;
	}

}
