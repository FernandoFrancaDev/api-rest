package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Tennis;
import app.repository.TennisRepository;

@Service
public class TennisService {
	
	@Autowired
	private TennisRepository tennisRepository;
	
	public String save (Tennis tennis) {
		this.tennisRepository.save(tennis);
		return "Tennis Salvo com sucesso";			
	}
	public String update(Tennis tennis, long id) {
		tennis.setId(id);
		this.tennisRepository.save(tennis);
		return "Tennis atualizado com sucesso";
	}
	public String delete(long id) {
		this.tennisRepository.deleteById(id);
		return "Tennis deletado com sucesso";
	}
	public List<Tennis> findAll(){
		List<Tennis> lista = this.tennisRepository.findAll();
		return lista;		
	}	
	public Tennis findById(Long id) {
		Tennis tennis = this.tennisRepository.findById(id).get();
		return tennis;
		
	}

}
