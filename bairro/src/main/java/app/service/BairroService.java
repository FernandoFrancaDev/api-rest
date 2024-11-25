package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Bairro;
import app.repository.BairroRepository;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository bairroRepository;
	
	public String save(Bairro bairro) {
		this.bairroRepository.save(bairro);		
		return "Bairro salvo com sucesso!";
	}
	public String update(Bairro bairro, long id) {
		bairro.setId(id);
		this.bairroRepository.save(bairro);
		return "Bairro atualizado com sucesso!";
	}
	public String delete(long id) {
		this.bairroRepository.deleteById(id);
		return "Bairro deletado com sucesso!";
	}
	public List<Bairro> findAll(){
		List<Bairro> lista = this.bairroRepository.findAll();
		return lista;
	}
	public Bairro findById(long id) {
		Bairro bairro = this.bairroRepository.findById(id).get();
		return bairro;
	}

}
