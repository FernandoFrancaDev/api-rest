package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import app.entity.Casa;
import app.entity.Marca;
import app.repository.CasaRepository;

@Service
public class CasaService {
	
	@Autowired
	private CasaRepository casaRepository;
	
	public String save(Casa casa) {
		this.casaRepository.save(casa);
		return "Casa salva com sucesso!";
	}
	public String update(Casa casa, long id) {
		casa.setId(id);
		this.casaRepository.save(casa);
		return "Casa Atualizada com sucesso!";
	}
	public String delete(long id) {
		this.casaRepository.deleteById(id);
		return "Casa deletada com sucesso";
	}
	public List<Casa> findAll(){
		List<Casa> lista = this.casaRepository.findAll();
		return lista;
	}
	public Casa findById(long id) {
		Casa casa = this.casaRepository.findById(id).get();
		return casa;
	}	
	public List<Casa> findByNome (String nome){
		return this.casaRepository.findByNome(nome);		
	}	
	public List<Casa> findByMarca(long id){
		Marca marca = new  Marca();
		marca.setId(id);
		List<Casa> lista = this.casaRepository.findByMarca(marca);
		return lista;
	}	
	public List<Casa> findAcimaAnoFabricacao(int anoFabricacao){
		return this.casaRepository.findAcimaAnoFabricacao(anoFabricacao);
	}

}
