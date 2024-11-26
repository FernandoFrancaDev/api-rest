package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Computador;
import app.entity.Marca;
import app.repository.ComputadorRepository;

@Service
public class ComputadorService {
	
	@Autowired
	private ComputadorRepository computadorRepository;
	
	public String save(Computador computador) {		
		this.computadorRepository.save(computador);		
		return "Computador salvo com sucesso";			
	}
	public String update(Computador computador, long id) {		
		computador.setId(id);
		this.computadorRepository.save(computador);		
		return "Computador atualizado com sucesso";			
	}
	public String delete(long id) {		
		this.computadorRepository.deleteById(id);
		return "Computador deletado com sucesso";			
	}
	public List<Computador> findAll(){	
		List<Computador> lista = this.computadorRepository.findAll();	
		return lista;
	}
		public Computador findById(Long id) {	
		Optional<Computador> computador = this.computadorRepository.findById(id);		
		return computador.get();
	}
		public List<Computador> findByNome(String nome){
			return this.computadorRepository.findByNome(nome);
			//return lista;
		}
		public List<Computador> findByMarca(long id){
			Marca marca = new Marca();
			marca.setId(id);
			return this.computadorRepository.findByMarca(marca);
		}
		public List<Computador> findAcimaValor (double valor){
		List<Computador> lista = this.computadorRepository.findAcimaValor(valor);
		return lista;
		}
		
}
