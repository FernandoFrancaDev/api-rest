package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Mochila;
import app.repository.MochilaRepository;

@Service
public class MochilaService {
	
	@Autowired
	private MochilaRepository mochilaRepository;
	
	public String save(Mochila mochila) {
		this.mochilaRepository.save(mochila);
		return "Mochila Salva com sucesso";
	}
	public String update(Mochila mochila, long id) {
		mochila.setId(id);
		this.mochilaRepository.save(mochila);
		return"Mochila atualizada com sucesso";
	}
	public String delete(long id) {
		this.mochilaRepository.deleteById(id);
		return "Mochila deletada com sucesso!";
	}
	public List<Mochila> findAll(){
		List<Mochila> lista = this.mochilaRepository.findAll();
		return lista;
	}
	public Mochila findById(long id) {
		Mochila mochila = this.mochilaRepository.findById(id).get();
		return mochila;
	}

}
