package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cerveja;
import app.repository.CervejaRepository;

@Service
public class CervejaService {
	
	@Autowired
	private CervejaRepository cervejaRepository;
	
	public String save(Cerveja cerveja) {
		this.cervejaRepository.save(cerveja);
		return "Cerveja salva com sucesso";
	}
	public String update(Cerveja cerveja, long id) {
		cerveja.setId(id);
		this.cervejaRepository.save(cerveja);
		return "Cerveja atualizada com sucesso";
	}
	public String delete (long id) {
		this.cervejaRepository.findById(id);
		return "Cerveja deletada com sucesso";
	}
	public List<Cerveja> findAll(){
		List<Cerveja> lista = this.cervejaRepository.findAll();
		return lista;
	}
	public Cerveja findById(long id){
		Cerveja cerveja = this.cervejaRepository.findById(id).get();
		return cerveja;
	}

}
