package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Oculos;
import app.entity.Saida;
import app.repository.OculosRepository;

@Service
public class OculosService {
	
	@Autowired
	private OculosRepository oculosRepository;
	
	public String save(Oculos oculos) {		
		
		this.oculosRepository.save(oculos);
		
		return "Óculos salvo com sucesso";
	}
	public Oculos findById(Long id) {		
		Optional<Oculos> oculos= this.oculosRepository.findById(id);
		return oculos.get();
	}
	public List<Oculos> findAll(){
		List<Oculos >oculos = this.oculosRepository.findAll();
		return oculos;
	}
	public Saida calcular(Oculos oculos) {
		Saida saida = new Saida();
		saida.setSoma(this.somar(oculos.getLista()));
		return saida;
	}
	public int somar(List<Integer> lista) {
		int soma = 0;
		for(int i = 0; i < lista.size(); i++)
			if(lista.get(i) != null)
			soma += lista.get(i);
		return soma;
	}
	

}
