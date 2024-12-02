package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Vitamina;
import app.repository.VitaminaRepository;

@Service
public class VitaminaService {
	
	@Autowired
	private VitaminaRepository vitaminaRepository;
	
	public String save(Vitamina vitamina) {
		this.vitaminaRepository.save(vitamina);
		return "Vitamina salva com sucesso";
	}
	public String update(Vitamina vitamina, long id) {
		vitamina.setId(id);
		this.vitaminaRepository.save(vitamina);
		return "Vitamina atualizada com sucesso";
	}
	public String delete(long id) {
		this.vitaminaRepository.deleteById(id);
		return "Vitamina deletada com sucesso";
	}
	public List<Vitamina>findAll(){
		List<Vitamina> lista = this.vitaminaRepository.findAll();
		return lista;
	}
	public Vitamina findById(long id) {
		Vitamina vitamina = this.vitaminaRepository.findById(id).get();
		return vitamina;
	}

}
