package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Sorvete;
import app.repository.SorveteRepository;

@Service
public class SorveteService {
	
	@Autowired
	SorveteRepository sorveteRepository;
	
	public String save(Sorvete sorvete) {
		
		this.sorveteRepository.save(sorvete);
		return "Sorvete salvo com sucesso";
	}
	
	public Sorvete findById(Long id) {		
		Optional<Sorvete> sorvete = this.sorveteRepository.findById(id);
		return sorvete.get();
		
	}

}
