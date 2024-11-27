package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Aviao;
import app.entity.Marca;

public interface AviaoRepository extends JpaRepository<Aviao, Long> {
	
	public List<Aviao> findByNome(String nome);
	
	public List<Aviao> findByMarca(Marca marca);	
	
	@Query("FROM Aviao c WHERE c.ano > :ano")
	public List<Aviao> findAcimaAno(int ano);

}
