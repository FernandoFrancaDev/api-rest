package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Protetor;
import app.entity.Saida;
import app.repository.ProtetorRepository;

@Service
public class ProtetorService {
	
	@Autowired
	private ProtetorRepository protetorRepository;
	
	public String save(Protetor protetor) {
		this.protetorRepository.save(protetor);
		return "Protetor Salvo com suceso!";
	}
	public String update(Protetor protetor, long id) {
		protetor.setId(id);
		this.protetorRepository.save(protetor);
		return "Protetor atualizado com sucesso!";
	}
	public String delete(long id) {
		this.protetorRepository.deleteById(id);
		return "Produto deletado com sucesso!";
	}
	public List<Protetor> findAll() {
		List<Protetor> lista = this.protetorRepository.findAll();
		return lista;
	}
	public Protetor findById(long id) {
		Protetor protetor = this.protetorRepository.findById(id).get();
		return protetor;
	}
	public Saida calcular(Protetor protetor) {
		Saida saida = new Saida();
		saida.setSoma(this.somar(protetor.getLista()));
		return saida;
	}
	public int somar(List<Integer> lista) {
		int soma = 0;
		for(int i = 0; i < lista.size(); i++)
		//	if(lista.get(i) != null)
			soma += lista.get(i);
		return soma;			
		
	}

}
