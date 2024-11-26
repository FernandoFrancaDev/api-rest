package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Celular;
import app.entity.Entrada;
import app.entity.Marca;
import app.entity.Resultado;
import app.repository.CelularRepository;

@Service
public class CelularService {
	
	@Autowired
	private CelularRepository celularRepository;

	
	public String save(Celular celular) {		
		this.celularRepository.save(celular);		
		return "Celular salvo com sucesso";
	}
	public String update(Celular celular, long id) {	
		celular.setId(id);
		this.celularRepository.save(celular);		
		return "Celular atualizado com sucesso";
	}
	public String delete(long id) {		
		this.celularRepository.deleteById(id);		
		return "Celular deletado com sucesso";
	}
	public List<Celular> findAll(){
		List<Celular> lista = this.celularRepository.findAll();
		return lista;
	}	
	public Celular findById(Long id) {		
		Optional<Celular> celular = this.celularRepository.findById(id);
		return celular.get();
	}
	public Resultado somar(Entrada entrada) {		
		Resultado resultado = new Resultado();
		Integer soma = 0;
				
		if(entrada.getLista() != null)
			for(int i = 0; i < entrada.getLista().size(); i++) {
				soma = soma + entrada.getLista().get(i);
			}
		resultado.setSoma(soma);
		return resultado;
	}
	
	public List<Celular>findByNome(String nome){
		List<Celular> lista = this.celularRepository.findByNome(nome);
		return lista;	
	}
	
	public List<Celular>findByMarca(long id){
		Marca marca = new Marca();
		marca.setId(id);
		return this.celularRepository.findByMarca(marca);
	}
	public List<Celular> findAcimaAno (int ano){
		return this.celularRepository.findAcimaAno(ano);		
	}

}
