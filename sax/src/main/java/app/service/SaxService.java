package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Sax;
import app.repository.SaxRepository;

@Service
public class SaxService {
	
	@Autowired
	private SaxRepository saxRepository;
	
	public String save(Sax sax) {
		this.saxRepository.save(sax);
		return "Sax salvo com sucesso";
	}
	public String updade (Sax sax, long id) {
		sax.setId(id);
		this.saxRepository.save(sax);
		return "Sax atualizado com sucesso";
	}
	public String delete(long id) {
		this.saxRepository.deleteById(id);
		return "Sax deletado com sucesso";
	}
	public List<Sax> findAll(){
		List<Sax> lista = this.saxRepository.findAll();
		return lista;
	}
	public Sax findById(long id) {
		Sax sax = this.saxRepository.findById(id).get();
		return sax;
	}

}
