package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Comida;
import app.entity.Marca;
import app.repository.ComidaRepository;

@Service
public class ComidaService {
	
	@Autowired
	private ComidaRepository comidaRepository;
	
	public String save (Comida comida) {
		this.comidaRepository.save(comida);
		return "Comida salva com sucesso!";
	}
	public String update (Comida comida, long id) {
		comida.setId(id);
		this.comidaRepository.save(comida);
		return "Comida atualizada com sucesso!";
	}
	public String delete (long id) {
		this.comidaRepository.deleteById(id);
		return "Comida deletada com sucesso!";
	}
	public List<Comida> findAll () {
	List<Comida> lista = this.comidaRepository.findAll();
		return lista;
	}	
	public Comida findById(Long id) {
		Optional<Comida> comida = this.comidaRepository.findById(id);
		return comida.get();		
	}
	public List<Comida> findByNome (String nome){
		List<Comida> lista = this.comidaRepository.findByNome(nome);
		return lista;
	}
	public List<Comida> findByMarca(long id){
		Marca marca = new Marca();
		marca.setId(id);
		return  this.comidaRepository.findByMarca(marca);		
	}
	public List<Comida> findAcimaValidade (int validade){
		return this.comidaRepository.findAcimaValidade(validade);		
	}

}
