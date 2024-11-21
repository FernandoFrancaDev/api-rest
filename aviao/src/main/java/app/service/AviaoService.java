package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aviao;
import app.repository.AviaoRepository;

@Service
public class AviaoService {
	
	@Autowired
	private AviaoRepository aviaoRepository;
	
	public String save(Aviao aviao) {
		this.aviaoRepository.save(aviao);
		return "Aviao salvo com sucesso";
	}
	public String update(Aviao aviao, long id) {
		aviao.setId(id);
		this.aviaoRepository.save(aviao);
		return "Aviao atualizado com sucesso";
	}
	public String delete(long id) {
		this.aviaoRepository.deleteById(id);
		return "Aviao salvo com sucesso";
	}
	public List<Aviao> FindAll() {
		List<Aviao> lista = this.aviaoRepository.findAll();
		return lista;
	}
	public Aviao FindById(long id) {
		Aviao aviao = this.aviaoRepository.findById(id).get();
		return aviao;
	}

}