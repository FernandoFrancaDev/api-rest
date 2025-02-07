package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Marca;
import app.entity.Piano;
import app.repository.PianoRepository;

@Service
public class PianoService {
	
	@Autowired
	private PianoRepository pianoRepository;
	
	public String save (Piano piano) {
		this.pianoRepository.save(piano);
		return "Piano salvo com sucesso";
	}
	public String update(Piano piano, long id) {
		piano.setId(id);
		this.pianoRepository.save(piano);
		return "Piano atualizado com sucesso";
	}
	public String delete(long id) {
		this.pianoRepository.deleteById(id);
		return "Piano deletado com sucesso";
	}
	public List<Piano> findAll(){
	List<Piano> lista = this.pianoRepository.findAll();
		return lista;
	}	
	public Piano findById(long id) {
		Piano piano = this.pianoRepository.findById(id).get();
		return piano;
	}
	public List<Piano> findByNome(String nome){
	List<Piano> lista = this.pianoRepository.findByNome(nome);
		return lista;
	}
	public List<Piano> findByMarca(long id){
		Marca marca = new Marca();
		marca.setId(id);
		return this.pianoRepository.findByMarca(marca);	
		}
	public List<Piano> findAcimaAno(String anoFabricacao){
		return this.pianoRepository.findAcimaAno(anoFabricacao);
	}
}
