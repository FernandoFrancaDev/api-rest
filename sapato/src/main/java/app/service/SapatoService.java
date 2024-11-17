package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Sapato;
import app.repository.SapatoRepository;

@Service
public class SapatoService {
	
	@Autowired
	private SapatoRepository sapatoRepository;
	
	public String save(Sapato sapato) {
		this.sapatoRepository.save(sapato);
		return "Sapato salvo com sucesso";
	}
	public String update (Sapato sapato, long id) {
		sapato.setId(id);
		this.sapatoRepository.save(sapato);
		return "Sapato atualizado com sucesso";
	}
	public String delete(long id) {
		this.sapatoRepository.deleteById(id);
		return "Sapato deletado com sucesso";
	}
	public List<Sapato> findAll(){
		List<Sapato> lista = this.sapatoRepository.findAll();
		return lista;
	}
	public Sapato findById(long id) {
		Sapato sapato = this.sapatoRepository.findById(id).get();
		return sapato;
	}

}
