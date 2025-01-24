package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Saida;
import app.entity.Sorvete;
import app.repository.SorveteRepository;

@Service
public class SorveteService {
	
	@Autowired
	SorveteRepository sorveteRepository;
	
	public String save(Sorvete sorvete) {
		
		this.sorveteRepository.save(sorvete);
		return "Sorvete salvo com sucesso";
	}
	
	public Sorvete findById(Long id) {		
		Optional<Sorvete> sorvete = this.sorveteRepository.findById(id);
		return sorvete.get();		
	}
	public List<Sorvete> findAll(){
		List<Sorvete> lista = this.sorveteRepository.findAll();
		return lista;
	}
	public Saida calcular(Sorvete sorvete) {
		Saida saida = new Saida();
		saida.setSoma(this.somar(sorvete.getLista()));
		return saida;
	}
	public int somar(List<Integer> lista) {
		int soma = 0;
		for (int i = 0; i < lista.size(); i++)
			soma += lista.get(i);
		return soma;
		
	}

}
