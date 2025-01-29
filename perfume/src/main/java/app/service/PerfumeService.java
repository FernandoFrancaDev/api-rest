package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Perfume;
import app.entity.Saida;
import app.repository.PerfumeRepository;

@Service
public class PerfumeService {
	
	@Autowired
	PerfumeRepository perfumeRepository;
	
	public String save(Perfume perfume) {
		this.perfumeRepository.save(perfume);
		return "Perfume salvo com sucesso";
	}
	public String update(Perfume perfume, long id) {
		perfume.setId(id);
		this.perfumeRepository.save(perfume);
		return "Perfume atualizado com sucesso";
	}
	public String delete(long id) {
		this.perfumeRepository.deleteById(id);
		return "Perfume deletado com sucesso";
	}
	public List<Perfume> findAll(){
	List<Perfume> lista = this.perfumeRepository.findAll();
		return lista;
	}
	public Perfume findById(long id) {
		Perfume perfume = this.perfumeRepository.findById(id).get();
		return perfume;
	}
	public Saida calcular(Perfume perfume) {
		Saida saida = new Saida();
		saida.setSoma(this.somar(perfume.getLista()));
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
