package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livros;
import app.repository.LivrosRepository;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	public String save(Livros livros) {
		this.livrosRepository.save(livros);		
		return "Livro salvo com sucesso!";
		
	}
	public Livros findByID(Long id) {		
		Optional<Livros> livros = this.livrosRepository.findById(id);
		return livros.get();		
	}
	public List<Livros> findAll(){
		List<Livros> lista = this.livrosRepository.findAll();
		return lista;
	}

}
