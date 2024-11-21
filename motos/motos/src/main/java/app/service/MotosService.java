package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Marca;
import app.entity.Motos;
import app.repository.MotosRepository;

@Service
public class MotosService {
	
	@Autowired
	MotosRepository motosRepository;
	
	public String save(Motos motos) {		
		this.motosRepository.save(motos);		
		return "Moto Salva com sucesso";
	}
	
	public String update(Motos motos, long id) {
		motos.setId(id);
		this.motosRepository.save(motos);		
		return "Moto Salva com sucesso";
	}
	
	public String delete(long id) {		
		this.motosRepository.deleteById(id);	
		return "Moto Salva com sucesso";
	}
	
	public List<Motos> findAll() {		
		List<Motos> lista = this.motosRepository.findAll();
		return lista;
	}
	
	public Motos findById(Long id) {		
		Optional<Motos> motos = this.motosRepository.findById(id);
		return motos.get();
		
	}
	public List<Motos> findByNome(String nome){
		return this.motosRepository.findByNome(nome);
	}
	public List<Motos> findByMarca(long id){
		Marca marca = new Marca();
		marca.setId(id);
		return this.motosRepository.findByMarca(marca);
	}
	public List<Motos> findAcimaAno(int ano){
		return this.motosRepository.FindAcimaAno(ano);
	}

}
