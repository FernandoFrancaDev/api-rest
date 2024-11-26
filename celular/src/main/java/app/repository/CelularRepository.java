package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Celular;
import app.entity.Marca;

public interface CelularRepository extends JpaRepository<Celular, Long>{
	
	public List<Celular> findByNome(String nome);
	
	public List<Celular> findByMarca(Marca marca);
	
	
	@Query("FROM Celular c WHERE c.ano > :ano")
	public List<Celular> findAcimaAno(int ano);

}


