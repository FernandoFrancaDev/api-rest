package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Impressora;
import app.entity.Resultado;
import app.repository.ImpressoraRepository;

@Service
public class ImpressoraService {
	
	@Autowired
	private ImpressoraRepository impressoraRepository;
	
	public Resultado calcular(Entrada entrada) {
		Resultado resultado = new Resultado();
		resultado.setSoma(this.somar(entrada.getLista()));		
		return resultado;
	}
	public int somar(List<Integer> lista) {
		int soma = 0;	
		for(int i = 0; i < lista.size(); i++) 
			if(lista.get(i) != null)
			soma = soma + lista.get(i);
		return soma;
		}
	
	public String save(Impressora impressora) {
		
		this.impressoraRepository.save(impressora);		
		return "Impressora salva com sucesso";
	}	
	public Impressora findById(Long id) {		
		Optional<Impressora> impressora = this.impressoraRepository.findById(id);
		return impressora.get();
	}
	public List<Impressora> findAll(){
		List<Impressora> lista  = this.impressoraRepository.findAll();
		return lista;
		
	}
	

}
