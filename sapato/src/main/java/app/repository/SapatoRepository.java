package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Marca;
import app.entity.Sapato;

public interface SapatoRepository extends JpaRepository<Sapato, Long> {
	
	public List<Sapato> findByNome(String nome);
	
	public List<Sapato> findByMarca(Marca marca);	
	
	//	public List<Sapato> findByMarcaNome(String nome);
	
	@Query("SELECT c FROM Sapato c WHERE c.tamanho > :tamanho")
	public List<Sapato> findAcimaTamanho(String tamanho);
	

}
