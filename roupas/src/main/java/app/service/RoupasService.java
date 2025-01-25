package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Roupas;
import app.repository.RoupasRepository;

@Service
public class RoupasService {
	
	@Autowired
	private RoupasRepository roupasRepository;
	
	public String save (Roupas roupas) {
		this.roupasRepository.save(roupas);
		return "Roupas salvas com sucesso";
	}
	
	public Roupas findById(Long id) {
		Optional<Roupas> roupas = this.roupasRepository.findById(id);
		return roupas.get();
	}
	public List<Roupas> findAll(){
		List<Roupas>lista = this.roupasRepository.findAll();
		return lista;
		
	}

}
