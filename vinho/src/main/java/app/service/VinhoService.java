package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Marca;
import app.entity.Vinho;
import app.repository.VinhoRepository;

@Service
public class VinhoService {
	
	@Autowired
	private VinhoRepository vinhoRepository;
	
	public String save(Vinho vinho) {
		this.vinhoRepository.save(vinho);
		return "Vinho salvo com sucesso";
	}
	public String update(Vinho vinho, long id) {
		vinho.setId(id);
		this.vinhoRepository.save(vinho);
		return "Vinho atualizado com sucesso";
	}
	public String delete(long id) {
		this.vinhoRepository.deleteById(id);
		return "Vinho deletado com sucesso";
	}
	public List<Vinho> findAll(){
		List<Vinho> lista = this.vinhoRepository.findAll();
		return lista;
	}
	public Vinho findById(long id) {
		Vinho vinho = this.vinhoRepository.findById(id).get();
		return vinho;
	}
	public List<Vinho> findByNome(String nome){
		List<Vinho> lista = this.vinhoRepository.findByNome(nome);
		return lista;
	}
	public List<Vinho> findByMarca(Long id){
		Marca marca = new Marca();
		marca.setId(id);
		return this.vinhoRepository.findByMarca(marca);		
	}
}
