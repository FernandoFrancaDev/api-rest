package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Barco;
import app.repository.BarcoRepository;

@Service
public class BarcoService {
	
	@Autowired
	private BarcoRepository barcoRepository;
	
	
	public String save(Barco barco) {
		this.barcoRepository.save(barco);
		return "Barco salvo com sucesso";
	}
	public String update(Barco barco, long id) {
		barco.setId(id);
		this.barcoRepository.save(barco);
		return "Barco atualizado com sucesso";
	}
	public String delete(long id) {
		this.barcoRepository.deleteById(id);
		return "Barco deletado com sucesso";
	}
	public List<Barco>findAll(){
		List<Barco>lista = this.barcoRepository.findAll();
		return lista;
	}
	public Barco findById(long id) {
		Barco barco = this.barcoRepository.findById(id).get();
		return barco;
	}
}
