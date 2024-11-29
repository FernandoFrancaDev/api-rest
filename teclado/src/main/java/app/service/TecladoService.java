package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Marca;
import app.entity.Teclado;
import app.repository.TecladoRepository;

@Service
public class TecladoService {
	
	@Autowired
	private TecladoRepository tecladoRepository;
	
	public String save(Teclado teclado) {
		this.tecladoRepository.save(teclado);
		return "Teclado Salvo com sucesso";
	}
	
	public String update(Teclado teclado, long id) {
		teclado.setId(id);
		this.tecladoRepository.save(teclado);
		return "Teclado Salvo com sucesso";
	}
	
	public String delete(long id) {
		this.tecladoRepository.deleteById(id);
		return "Teclado deletado com sucesso";
	}
	public List<Teclado> findAll() {
		List<Teclado> lista = this.tecladoRepository.findAll();
		return lista;
	}
	public Teclado findByIf(long id) {
		Teclado teclado = this.tecladoRepository.findById(id).get();
		return teclado;
	}
	public List<Teclado> findByNome(String nome){
		return this.tecladoRepository.findByNome(nome);
	}
	public List<Teclado> findByMarca(long id){
		Marca marca = new Marca();
		marca.setId(id);
		return this.tecladoRepository.findByMarca(marca);		
	}
	public List<Teclado> findAcimaAno(int ano){
		return this.tecladoRepository.findAcimaAno(ano);
	}

}
